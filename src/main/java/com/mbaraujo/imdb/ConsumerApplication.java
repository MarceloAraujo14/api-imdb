package com.mbaraujo.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ConsumerApplication {

	public static void main(String[] args){
		SpringApplication.run(ConsumerApplication.class);


	}

}

