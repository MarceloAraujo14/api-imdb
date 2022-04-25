package com.mbaraujo.imdb.api.controller;


import com.mbaraujo.imdb.api.model.MovieModel;
import com.mbaraujo.imdb.api.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/movies")
public class MoviesController {


    private final MovieRequest movieRequest;

    @Autowired
    public MoviesController(MovieRequest movieRequest) {
        this.movieRequest = movieRequest;
    }

    @GetMapping(value = "/most-popular", produces = "application/json")
    public String getMostPopularMovies(Model model) throws Exception{
        List<MovieModel> movies = movieRequest.getMovies("https://imdb-api.com/en/API/Top250Movies/");

        model.addAttribute("movies", movies);
        return "index";
    }







}
