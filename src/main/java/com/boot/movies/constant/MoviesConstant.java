package com.boot.movies.constant;

import org.springframework.stereotype.Component;

@Component
public class MoviesConstant {


    public static final String ADD_SINGLE_MOVIE = "/addMovie";

    public static final String ADD_MULTIPLE_MOVIES = "/addMovies";
    public static final String VIEW_ALL_MOVIES = "/allMovies";

    public static final String VIEW_MOVIES_BY_CATEGORY = "/category/{movie_category}";

    public static final String MOVIE_BY_MOVIE_ID = "/{movie_id}";

    public static final String REST_URL = "/movies";

    public static final String MOVIES_BY_RATING = "/rating/{rating}";

    public static final String MOVIES_BY_RELEASE_YEAR = "/year/{releaseYear}";

    public static final String MOVIES_BY_DIRECTOR_NAME = "/directors/{director_name}";

    public static final String MOVIES_BY_DIRECTOR_ID = "/find-directors/{director_id}";


}
