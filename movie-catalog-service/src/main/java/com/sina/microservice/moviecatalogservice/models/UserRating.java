package com.sina.microservice.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	
	public UserRating() {
		super();
	}

	private List<MovieRating> movieRatings;

	public List<MovieRating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<MovieRating> movieRatings) {
		this.movieRatings = movieRatings;
	}
	
}
