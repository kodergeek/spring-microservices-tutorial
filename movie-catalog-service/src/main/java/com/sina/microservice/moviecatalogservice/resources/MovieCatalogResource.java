package com.sina.microservice.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.microservice.moviecatalogservice.models.CatalogItem;
import com.sina.microservice.moviecatalogservice.models.UserRating;
import com.sina.microservice.moviecatalogservice.services.MovieInfo;
import com.sina.microservice.moviecatalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRartingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
				
		UserRating ratings =  userRartingInfo.getRatings(userId);
				
		return ratings.getMovieRatings()
				.stream()
				.map(rating -> movieInfo.getCatalogItem(rating) )
				.collect(Collectors.toList());
	}
}