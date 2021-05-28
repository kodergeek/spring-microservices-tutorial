package com.sina.microservice.movieratingdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.microservice.movieratingdataservice.models.MovieRating;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingResource {
	
	@RequestMapping("/{movieId}")
	public MovieRating getRating(@PathVariable("movieId") String movieId) {
		return new MovieRating(movieId, 1000);
	}

}
