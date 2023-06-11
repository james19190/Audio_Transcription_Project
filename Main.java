import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class main {
    public static void main(String[] args) throws Exception {

        //create transcript object
        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://github.com/james19190/usingAPIS/blob/main/apiaudiotestJava.m4a?raw=true");

        //create new gson object then changes object to json
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        //create post HTTPRequest object
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("authorization", Keys.authKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        //creates Http Client
        HttpClient httpClient = HttpClient.newHttpClient();

        //receives response and places it in postResponse variable (as object HttpResponse)
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        transcript = gson.fromJson(postResponse.body(), Transcript.class);

        //create post HTTPRequest object
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("authorization", "5992e585cd8343569b06c5ebc07149a3")
                .GET()
                .build();

        while (true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getResponse.body(), Transcript.class);

            System.out.println(transcript.getStatus());
            if (transcript.getStatus().equals("completed") || transcript.getStatus().equals("error")) {
                break;
            }
            Thread.sleep(1000);
        }

        System.out.print("Transcription completed!\nThe transcription is :");
        System.out.println(transcript.getText());
    }
}
