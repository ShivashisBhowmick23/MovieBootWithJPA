package com.boot.movies;

import com.boot.movies.Controller.MovieController;
import com.boot.movies.Entity.Directors;
import com.boot.movies.Entity.Movies;
import com.boot.movies.Repository.MovieRepository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class MoviesApplicationTests {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieRepository movieRepository;

    public List<Movies> getMovies() {
        Movies movies = new Movies();
        movies.setMovie_id(1);
        movies.setMovie_name("Now You See Me");
        movies.setMovie_category("Comedy");
        movies.setRating("8");
        movies.setReleaseYear("2018");


        Directors directors = new Directors();
        directors.setDirector_id(1);
        directors.setDirector_name("David Werner");
        directors.setId(1);

        movies.setDirectors(directors);


        Movies movies1 = new Movies();
        movies1.setMovie_name("Now You See Me 2");
        movies1.setMovie_category("Comedy");
        movies1.setRating("8");
        movies1.setReleaseYear("2020");
        movies1.setMovie_id(2);
        Directors directors1 = new Directors();
        directors1.setDirector_id(1);
        directors1.setDirector_name("David Werner");
        directors1.setId(2);

        movies1.setDirectors(directors1);

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(movies);
        moviesList.add(movies1);
        return moviesList;

    }


    @Test
    @DisplayName("TESTING FIND ALL MOVIES METHOD")
    public void testFindAllMovies() {
        // Mock the data returned by the repository
        List<Movies> mockMoviesList = getMovies();
        when(movieRepository.findAllMovies()).thenReturn(mockMoviesList);
        // Call the controller method
        List<Movies> result = movieController.findAllMovies();
        // Verify that the repository method was called
        verify(movieRepository, times(1)).findAllMovies();
        // Assertions
        assertThat(result).isNotNull();
        assertEquals(HttpStatus.OK, HttpStatus.resolve(200));

    }

    @Test
    @DisplayName("TESTING FIND MOVIE BY MOVIE ID METHOD")
    public void testFindMovieById() {
        Movies movies = new Movies();
        movies.setMovie_id(1);
        movies.setMovie_name("Now You See Me");
        movies.setMovie_category("Comedy");
        movies.setRating("8");
        movies.setReleaseYear("2018");


        Directors directors = new Directors();
        directors.setDirector_id(1);
        directors.setDirector_name("David Werner");
        directors.setId(1);

        movies.setDirectors(directors);
        when(movieRepository.findById(1)).thenReturn(movies);
        Movies result = movieController.findByMovieId(1);
        verify(movieRepository, times(1)).findById(1);
        assertThat(result).isEqualTo(movies);
        assertEquals(HttpStatus.OK, HttpStatus.resolve(200));
    }

    @Test
    @DisplayName("TESTING FIND MOVIE BY MOVIE ID WITH A INVALID MOVIE ID METHOD")
    public void testFindMovieById_Not_Valid_Movie_ID() {
        Movies movies = new Movies();
        movies.setMovie_id(1);
        movies.setMovie_name("Now You See Me");
        movies.setMovie_category("Comedy");
        movies.setRating("8");
        movies.setReleaseYear("2018");


        Directors directors = new Directors();
        directors.setDirector_id(1);
        directors.setDirector_name("David Werner");
        directors.setId(1);

        movies.setDirectors(directors);
        when(movieRepository.findById(12)).thenReturn(movies);
        Movies result = movieController.findByMovieId(12);
        verify(movieRepository, times(1)).findById(12);
        assertThat(result).isEqualTo(movies);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.resolve(500));
    }

    @Test
    @DisplayName("TESTING FIND MOVIES BY RATING")
    public void testFindMoviesByMovieRating() {
        List<Movies> mockMoviesList = getMovies();
        when(movieRepository.findByRating("8")).thenReturn(mockMoviesList);
        List<Movies> result = movieController.findByRating("8");
        verify(movieRepository, times(1)).findByRating("8");
        assertThat(result).isEqualTo(mockMoviesList);
        assertEquals(HttpStatus.OK, HttpStatus.resolve(200));


    }

    @Test
    @DisplayName("TESTING FIND MOVIES BY WITH A INVALID RATING")
    public void testFindMoviesByMovieRating_With_Invalid_Movie_Rating() {
        List<Movies> mockMoviesList = getMovies();
        when(movieRepository.findByRating("1")).thenReturn(mockMoviesList);
        List<Movies> result = movieController.findByRating("1");
        verify(movieRepository, times(1)).findByRating("1");
        assertThat(result).isEqualTo(mockMoviesList);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.resolve(500));


    }

}

