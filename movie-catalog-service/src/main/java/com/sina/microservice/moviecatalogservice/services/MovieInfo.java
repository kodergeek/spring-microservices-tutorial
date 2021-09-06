package com.sina.microservice.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sina.microservice.moviecatalogservice.models.CatalogItem;
import com.sina.microservice.moviecatalogservice.models.Movie;
import com.sina.microservice.moviecatalogservice.models.MovieRating;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(MovieRating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating() );
	}

	
	public CatalogItem getFallbackCatalogItem(MovieRating rating) {
		CatalogItem item = new CatalogItem("name not found", "no descriptin", rating.getRating());
		return item;
	}
}
