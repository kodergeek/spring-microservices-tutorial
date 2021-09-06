package com.sina.microservice.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	
	public UserRating() {
		super();
	}

    private String userId;


	private List<MovieRating> movieRatings;

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<MovieRating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<MovieRating> movieRatings) {
		this.movieRatings = movieRatings;
	}
	
}
