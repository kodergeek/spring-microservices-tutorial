package com.sina.microservice.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //not mandatory but to make it clear that this is a eureka client
public class MovieMovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMovieInfoServiceApplication.class, args);
	}

}
