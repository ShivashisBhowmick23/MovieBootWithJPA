package com.boot.movies.Repository;

import com.boot.movies.Entity.Directors;
import com.boot.movies.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorsRepository extends JpaRepository<Directors, Integer> {


}
