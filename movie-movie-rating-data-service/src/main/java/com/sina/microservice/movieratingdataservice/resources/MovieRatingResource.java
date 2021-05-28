package com.sina.microservice.movieratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.microservice.movieratingdataservice.models.MovieRating;
import com.sina.microservice.movieratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingResource {
	
	@RequestMapping("/{movieId}")
	public MovieRating getRating(@PathVariable("movieId") String movieId) {
		return new MovieRating(movieId, 1000);
	}

	@RequestMapping("users/{userId}")
	public   UserRating getUserRating(@PathVariable("userId") String movieId) {
		List<MovieRating> ratings = Arrays.asList(
						new MovieRating("123", 10),
						new MovieRating("445", 20));

		UserRating userRatings = new UserRating();
		userRatings.setMovieRatings(ratings);
		return userRatings;
	}
	
}
