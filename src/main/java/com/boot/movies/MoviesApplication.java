package com.boot.movies;

import com.boot.movies.Entity.Movies;
import com.boot.movies.Repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MoviesApplication{


    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);


        System.out.println("Starting MovieBoot Application with JPA");
    }
}

