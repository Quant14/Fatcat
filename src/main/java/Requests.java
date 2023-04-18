import okhttp3.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Requests {
    private static final String PROPERTIES_FILE = "src/main/resources/application.properties";
    private static final Properties resources = new Properties();

    public Requests() {
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            resources.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setAdminSettings(String totalGuards, String totalSectors) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody
                .create(mediaType, "{\n    \"totalguards\": \"" + totalGuards + "\",\n    \"totalsectors\": \"" + totalSectors + "\"\n}");
        Request request = new Request.Builder()
                .url(resources.getProperty("server.url") + "admin")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getSectorsCount() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url(resources.getProperty("server.url") + "admin/sectorcnt")
                .build();
        try {
            Response response = client.newCall(request).execute();

            assert response.body() != null;
            return Integer.parseInt(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addPersonRequest(String name, String sector, String description, String danger) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody
                .create(mediaType, "{\n    \"name\": \"" + name + "\",\n    \"sector\": \"" + sector + "\",\n    \"description\": \"" + description + "\",\n    \"danger\": \"" + danger + "\"\n}");
        Request request = new Request.Builder()
                .url(resources.getProperty("server.url") + "person")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAllPersons() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(resources.getProperty("server.url") + "person")
                .method("DELETE", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> processData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(resources.getProperty("server.url") + "processData")
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            var stringBody = response.body().string();

            return Arrays.stream(stringBody.substring(1, stringBody.length() - 1).split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}