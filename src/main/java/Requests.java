import okhttp3.*;

import java.io.IOException;

public class Requests {
    public Requests(){
    }

    public static void setAdminSettings(String totalGuards, String totalSectors){
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody
                .create(mediaType, "{\n    \"totalguards\": \"" + totalGuards + "\",\n    \"totalsectors\": \"" + totalSectors + "\"\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/admin")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getSectorsCount(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/admin/sectorcnt")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();

            return Integer.parseInt(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addPersonRequest(String name, String sector, String description, String danger){
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody
                .create(mediaType, "{\n    \"name\": \"" + name + "\",\n    \"sector\": \"" + sector + "\",\n    \"description\": \"" + description + "\",\n    \"danger\": \"" + danger + "\"\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/person")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAllPersons(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/person")
                .method("DELETE", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
