import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Requests {
    public Requests(){
//        try{
//            URL url = new URL("localhost:8080/api/sectors");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("POST");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create("localhost:8080/api/sectors")).build();

        //var response = client.send(request, new );
    }
}
