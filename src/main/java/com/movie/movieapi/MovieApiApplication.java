package com.movie.movieapi;

import com.movie.movieapi.entity.Category;
import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.repository.CategoryRepository;
import com.movie.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MovieApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}
}
