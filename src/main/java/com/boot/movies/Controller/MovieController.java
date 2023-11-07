package com.boot.movies.Controller;

import com.boot.movies.Entity.Movies;
import com.boot.movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/{movie_id}")
    public Movies findByMoiveId(@PathVariable("movie_id") int movie_id){
     return    movieRepository.findById(movie_id);
    }

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movies movie){
         movieRepository.save(movie);
         return "Movie  added successfully with MovieID: "+movie.getMovie_id();
    }

    @PostMapping("/addMovies")
    public String addMovies(@RequestBody List<Movies> movies){
        movieRepository.saveAll(movies);
        return "Movies added successfully with MovieIDs: "+movies.toString();
    }
@GetMapping("/category/{movie_category}")
    public List<Movies> findMoviesByCategory(@PathVariable("movie_category") String movie_category){
        return movieRepository.findByCategory(movie_category);
    }

    @GetMapping("/allMovies")
    public List<Movies> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    @DeleteMapping("/{movie_id}")
    public String deleteByMovieId(@PathVariable("movie_id") int movie_id){
        movieRepository.deleteById(movie_id);
        return "Movie is Deleted Successfully with movieID:  "+movie_id;
    }

    @GetMapping("/rating/{rating}")
    public List<Movies> findByRating(@PathVariable("rating") String rating){
    List<Movies>  movies=   movieRepository.findByRating(rating);
        return movies.stream().toList();

    }

@GetMapping("/year/{releaseYear}")
    public List<Movies> findByReleaseYear(@PathVariable("releaseYear") String releaseYear){
      List<Movies>  movies= movieRepository.findByYear(releaseYear);
      return movies.stream().toList();
    }

}
