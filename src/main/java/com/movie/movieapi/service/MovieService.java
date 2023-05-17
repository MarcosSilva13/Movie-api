package com.movie.movieapi.service;

import com.movie.movieapi.dtos.MovieDTO;
import com.movie.movieapi.entity.Category;
import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.repository.MovieRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> new MovieDTO(movie))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findOrderByName() {
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream()
                .map(movie -> new MovieDTO(movie))
                .collect(Collectors.toList());
    }

    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        return new MovieDTO(movie);
    }

    public List<MovieDTO> findByName(String name) {
        return movieRepository.findByName(name)
                .stream()
                .map(movie -> new MovieDTO(movie))
                .collect(Collectors.toList());
    }

    @Transactional
    public MovieDTO insert(MovieDTO movieDTO) {
        checkValidCategoryId(movieDTO);

        Movie movie = new Movie();

        movie.setCategory(new Category(movieDTO.getCategoryDTO().getId()));

        BeanUtils.copyProperties(movieDTO, movie);

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

    @Transactional
    public MovieDTO update(MovieDTO movieDTO) {
        checkValidCategoryId(movieDTO);

        Movie movie = movieRepository.findById(movieDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("ID: " + movieDTO.getId() + " not found!"));

        movie.setCategory(new Category(movieDTO.getCategoryDTO().getId()));

        BeanUtils.copyProperties(movieDTO, movie);

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

    @Transactional
    public void deleteById(Long id) {
        movieRepository.deleteById(movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!")).getId());
    }

    private void checkValidCategoryId(MovieDTO movieDTO) {
        if (movieDTO.getCategoryDTO().getId() == null || movieDTO.getCategoryDTO().getId() <= 0) {
            throw new IllegalArgumentException("ID category cannot be null, empty or negative!");
        }
    }
}
