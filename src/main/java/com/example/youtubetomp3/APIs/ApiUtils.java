package com.example.youtubetomp3.APIs;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtils {
    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String response() throws IOException, InterruptedException {

        String requiredString;
        if (getUrl().contains("v=")){
         requiredString = getUrl().substring(getUrl().indexOf("v=")+2 , getUrl().indexOf("&"));
        }else {
            requiredString = getUrl().substring(getUrl().indexOf("be/")+3);

        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://youtube-mp3-download1.p.rapidapi.com/dl?id="+requiredString))
                .header("X-RapidAPI-Host", "youtube-mp3-download1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "71aa605dbdmshc910d6def3f0f5ap1e46c6jsn9d614a4b2718")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();


        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        String str = response.body();


        String req = str.substring(str.indexOf("link")+7 , str.indexOf("title") -3);

        title = str.substring(str.indexOf("title")+8 , str.indexOf("progress") -3);



        return req;
    }

}
