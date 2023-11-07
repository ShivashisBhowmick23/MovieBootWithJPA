package com.boot.movies.Repository;

import com.boot.movies.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM movies WHERE movie_id = ?")
    public Movies findById(int movie_id);
    @Query(nativeQuery = true,value = "SELECT * FROM movies WHERE movie_category = ?")
    public List<Movies> findByCategory(String movie_category);

    @Query(nativeQuery = true,value = "SELECT * FROM movies")
    public List<Movies> findAllMovies();

    @Query(nativeQuery = true, value = "SELECT * FROM movies WHERE rating = ?")
    public  List<Movies> findByRating(String rating);

    @Query(nativeQuery = true,value = "SELECT director_id,movie_id, movie_name, movie_category, rating, release_year FROM movies WHERE release_year = ?")
    public List<Movies> findByYear(String releaseYear);
}
