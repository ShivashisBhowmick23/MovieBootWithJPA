package com.boot.movies.Repository;

import com.boot.movies.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM movies WHERE movie_id = ?")
    public Movies findById(int movie_id);

    @Query(nativeQuery = true, value = "SELECT * FROM movies WHERE movie_category = ?")
    public List<Movies> findByCategory(String movie_category);

    @Query(nativeQuery = true, value = "SELECT * FROM movies")
    public List<Movies> findAllMovies();

    @Query(nativeQuery = true, value = "SELECT * FROM movies WHERE rating = ?")
    public List<Movies> findByRating(String rating);

    @Query(nativeQuery = true, value = "SELECT id, movie_id, movie_name, movie_category, rating, release_year FROM movies WHERE release_year = ?")
    public List<Movies> findByYear(String releaseYear);

    @Query(nativeQuery = true, value = "SELECT mvs.id, mvs.movie_id, mvs.movie_name, mvs.movie_category,mvs.release_year,mvs.rating FROM movies mvs join directors d on d.id = mvs.id where d.director_name=:director_name")
    public List<Movies> findByDirectorName(String director_name);

    @Query(nativeQuery = true, value = "SELECT mvs.id, mvs.movie_id, mvs.movie_name, mvs.movie_category,mvs.release_year,mvs.rating FROM movies mvs join directors d on d.id = mvs.id where d.director_id=:director_id")
    public List<Movies> findDirectorsById(int director_id);
}
