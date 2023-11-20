package com.boot.movies.Controller;

import com.boot.movies.Entity.Movies;
import com.boot.movies.Repository.MovieRepository;
import com.boot.movies.Constant.MoviesConstant;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Data
@RestController
@RequestMapping(value = MoviesConstant.REST_URL)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    @Autowired
    MovieRepository movieRepository;


    @GetMapping(value = MoviesConstant.MOVIE_BY_MOVIE_ID)
    public Movies findByMovieId(@PathVariable("movie_id") int movie_id) {
        logger.info("MovieID: " + movie_id);
        return movieRepository.findById(movie_id);
    }

    @PostMapping(value = MoviesConstant.ADD_SINGLE_MOVIE)
    public String addMovie(@RequestBody Movies movie) {
        movieRepository.save(movie);
        return "Movie  added successfully with MovieID: " + movie.getMovie_id();
    }

    @PostMapping(value = MoviesConstant.ADD_MULTIPLE_MOVIES)
    public String addMovies(@RequestBody List<Movies> movies) {
        movieRepository.saveAll(movies);
        return "Movies added successfully with MovieIDs: " + movies.toString();
    }

    @GetMapping(value = MoviesConstant.VIEW_MOVIES_BY_CATEGORY)
    public List<Movies> findMoviesByCategory(@PathVariable("movie_category") String movie_category) {
        return movieRepository.findByCategory(movie_category);
    }

    @GetMapping(value = MoviesConstant.VIEW_ALL_MOVIES)
    public List<Movies> findAllMovies() {
        List<Movies>allMovies=  movieRepository.findAllMovies();
        int totalCount = allMovies.size();
        logger.info("totalCount of Movies is:: "+totalCount);
        return allMovies;

    }

    @DeleteMapping(value = MoviesConstant.MOVIE_BY_MOVIE_ID)
    public String deleteByMovieId(@PathVariable("movie_id") int movie_id) {
        movieRepository.deleteById(movie_id);
        logger.info("Movie deleted::  "+ movie_id);
        return "Movie is Deleted Successfully with movieID:  " + movie_id;
    }

    @GetMapping(value = MoviesConstant.MOVIES_BY_RATING)
    public List<Movies> findByRating(@PathVariable("rating") String rating) {
        List<Movies> movies = movieRepository.findByRating(rating);
        return movies.stream().toList();

    }

    @GetMapping(value = MoviesConstant.MOVIES_BY_RELEASE_YEAR)
    public List<Movies> findByReleaseYear(@PathVariable("releaseYear") String releaseYear) {
        List<Movies> movies = movieRepository.findByYear(releaseYear);
        return movies.stream().toList();
    }


    @GetMapping(value = MoviesConstant.MOVIES_BY_DIRECTOR_NAME)
    public List<Movies> findByDirectorName(@PathVariable("director_name") String director_name) {
        List<Movies> movies = movieRepository.findByDirectorName(director_name);
        return movies.stream().toList();

    }

    @GetMapping(value = MoviesConstant.MOVIES_BY_DIRECTOR_ID)
    public List<Movies>  findDirectorsById(@PathVariable("director_id") int director_id) {
        List<Movies> movies = movieRepository.findDirectorsById(director_id);
        return movies.stream().toList();

    }

}
