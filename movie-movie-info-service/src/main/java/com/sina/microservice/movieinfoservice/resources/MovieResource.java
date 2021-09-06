package com.sina.microservice.movieinfoservice.resources;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sina.microservice.movieinfoservice.models.Movie;
import com.sina.microservice.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	String apikey; 

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		
		  String urlBuild =
		  "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apikey;
		  System.out.println("url is " + urlBuild);
	  		  
		  MovieSummary summary =
		  restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
		  "?api_key=" + apikey, MovieSummary.class);
		  
		  
		 
		
		return new Movie(summary.getId(), summary.getTitle(), summary.getOverview());
	}

}
