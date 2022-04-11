package com.mbaraujo.imdb.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel {

    private String title;
    private String image;
    private Integer year;
    @JsonAlias("imDbRating")
    private Double rating;

    @Override
    public String toString() {
        return  "title: '" + title + '\'' +
                "\n,image: '" + image + '\'' +
                "\n,year: " + year +
                "\n,rate: " + rating;
    }
}
