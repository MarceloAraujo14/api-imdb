package com.mbaraujo.imdb.api.controller;


import com.mbaraujo.imdb.api.model.MovieModel;
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

    @GetMapping(value = "/most-popular", produces = "application/json")
    public ResponseEntity getMostPopularMovies() throws Exception{

        List<MovieModel> movies = movieRequest.getMovies("https://imdb-api.com/en/API/Top250Movies/");

        return ResponseEntity.ok().body(movies);
    }





}
