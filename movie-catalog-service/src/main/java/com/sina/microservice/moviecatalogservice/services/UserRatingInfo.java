package com.sina.microservice.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sina.microservice.moviecatalogservice.models.MovieRating;
import com.sina.microservice.moviecatalogservice.models.UserRating;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackRatings")
	public UserRating getRatings(String userId) {
		return restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/" + userId,
				UserRating.class);
	}
	
	public UserRating getFallbackRatings(String userId) { 
		UserRating rating = new UserRating();
		rating.setUserId(userId);
		MovieRating movieRating = new MovieRating(userId, 0);
		rating.setMovieRatings(Arrays.asList(movieRating));
		return rating;
	}
}
