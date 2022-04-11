package com.mbaraujo.imdb.api.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbaraujo.imdb.api.model.MovieModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class MovieRequest {

    @Value("${imdb.key}")
    private String key;

    public List<MovieModel> getMovies(String uri) throws Exception{

        DateFormat dfYear = new SimpleDateFormat("yyyy");

        ObjectMapper mapper = new ObjectMapper();

        mapper.setDateFormat(dfYear);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create( uri + key))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        String moviesResponse = json.substring(json.indexOf("[")+1, json.lastIndexOf("]"));

        String[] movies = moviesResponse.replace("},{", "};{").split(";");

        List<MovieModel> movieList = new ArrayList<>();

        Stream.of(movies).forEach(
                movie -> {
                    try {
                        movieList.add(mapper.readerFor(MovieModel.class).readValue(movie));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
        );

        return movieList;
    }



}
