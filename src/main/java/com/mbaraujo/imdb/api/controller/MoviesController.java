package com.mbaraujo.imdb.api.controller;


import com.mbaraujo.imdb.api.request.MovieRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {

    private final MovieRequest movieRequest;

    public MoviesController(MovieRequest movieRequest) {
        this.movieRequest = movieRequest;
    }

    @GetMapping("/most-popular")
    public ResponseEntity<String> getMostPopularMovies(){
        List<String> movies = movieRequest.getMovies("https://imdb-api.com/en/API/Top250Movies/");
        for (String movie: movies) {
            System.out.println(movie + "\n");
        }
        return ResponseEntity.ok().body("lista");
    }
}
