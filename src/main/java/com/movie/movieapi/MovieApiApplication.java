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
public class MovieApiApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private MovieRepository movieRepository;
	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Action");
		Category cat2 = new Category(null,"Comedy");
		Category cat3 = new Category(null,"Drama");
		Category cat4 = new Category(null,"Horror");
		Category cat5 = new Category(null,"Sci-fi");

		Movie movie1 = new Movie(null, "Fast and Furious", cat1);
		Movie movie2 = new Movie(null, "Avengers", cat1);
		Movie movie3 = new Movie(null, "Back to the future", cat2);
		Movie movie4 = new Movie(null, "The Simpsons", cat2);
		Movie movie5 = new Movie(null, "Forrest Gump", cat3);
		Movie movie6 = new Movie(null, "Schindler's List", cat3);
		Movie movie7 = new Movie(null, "It", cat4);
		Movie movie8 = new Movie(null, "The Conjuring", cat4);
		Movie movie9 = new Movie(null, "Star Wars", cat5);
		Movie movie10 = new Movie(null, " Matrix", cat5);

		cat1.getMovies().addAll(Arrays.asList(movie1, movie2));
		cat2.getMovies().addAll(Arrays.asList(movie3, movie4));
		cat3.getMovies().addAll(Arrays.asList(movie5, movie6));
		cat4.getMovies().addAll(Arrays.asList(movie7, movie8));
		cat5.getMovies().addAll(Arrays.asList(movie9, movie10));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);
		categoryRepository.save(cat4);
		categoryRepository.save(cat5);

		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);
		movieRepository.save(movie4);
		movieRepository.save(movie5);
		movieRepository.save(movie6);
		movieRepository.save(movie7);
		movieRepository.save(movie8);
		movieRepository.save(movie9);
		movieRepository.save(movie10);
	}
}
