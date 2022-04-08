package com.mbaraujo.imdb.api.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MovieRequest {

    @Value("${imdb.key}")
    private String key;

    public List<String> getMovies(String uri){

        List<String> movies = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create( uri + key))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(m -> movies.addAll(List.of(m.replace("}],\"errorMessage\":\"\"}", "").replace("\"items\":[", "").replace("},", "").trim().split("[{]"))))
                .join();



        return movies;
    }

}
