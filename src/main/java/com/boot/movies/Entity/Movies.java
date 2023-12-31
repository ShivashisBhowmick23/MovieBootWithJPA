package com.boot.movies.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    private String movie_name;

    private String movie_category;



 protected Movies() { //for using JPA we need to use NO ARGUMENTS CONSTRUCTOR
    }

    public Movies(String movie_name, String movie_category) {

        this.movie_name = movie_name;
        this.movie_category = movie_category;
    }


    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public void setMovie_category(String movie_category) {
        this.movie_category = movie_category;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", movie_category='" + movie_category + '\'' +
                '}';
    }
}

   /*we don't want set the Id so we will exclude it from the constructor also we don't want to set it by the user
        so we won't keep the setter also for the id' */
