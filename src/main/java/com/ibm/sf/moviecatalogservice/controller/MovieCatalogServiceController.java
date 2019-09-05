package com.ibm.sf.moviecatalogservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ibm.sf.moviecatalogservice.model.Catalog;
import com.ibm.sf.moviecatalogservice.model.Movie;
import com.ibm.sf.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogServiceController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
    public List<Catalog> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratings/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new Catalog(movie.getTitle(), movie.getOverview(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}


