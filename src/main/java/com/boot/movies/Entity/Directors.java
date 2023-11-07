package com.boot.movies.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Directors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;
    private String director_name;

    @JsonIgnore()
    @OneToMany(mappedBy = "directors")
    private List<Movies> movies = new ArrayList<>();

}
