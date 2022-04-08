package com.mbaraujo.imdb;

import com.mbaraujo.imdb.config.UrlConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication

public class ConsumerApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class);



		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create("https://google.com.br"))
				.GET()
				.build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println)
				.join();

	}

}

