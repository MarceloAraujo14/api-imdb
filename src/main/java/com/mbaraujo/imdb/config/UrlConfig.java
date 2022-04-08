package com.mbaraujo.imdb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig {

    @Value("${imdb.key}")
    private String key;
    @Value("${imdb.uri}")
    private String uri;

    private String getUrl(){
        String url = String.format("%s%s", uri, key );
        return url;
    }

}
