package com.boot.movies.Repository;

import com.boot.movies.Entity.Directors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorsRepository extends JpaRepository<Directors, Integer> {

}
