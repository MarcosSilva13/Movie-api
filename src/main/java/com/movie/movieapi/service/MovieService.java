package com.movie.movieapi.service;

import com.movie.movieapi.dtos.MovieRequestDTO;
import com.movie.movieapi.dtos.MovieResponseDTO;
import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.repository.MovieRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import com.movie.movieapi.util.MovieConverter;
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

    @Transactional(readOnly = true)
    public List<MovieResponseDTO> findAll() {
        return movieRepository.searchAll()
                .stream()
                .map(MovieResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MovieResponseDTO> findOrderByName() {
        return movieRepository.searchAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream()
                .map(MovieResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MovieResponseDTO findById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        return new MovieResponseDTO(movie);
    }

    @Transactional(readOnly = true)
    public List<MovieResponseDTO> findByName(String name) {
        return movieRepository.findByName(name)
                .stream()
                .map(MovieResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public MovieResponseDTO insert(MovieRequestDTO movieRequestDTO) {
        Movie movie = new Movie();

        MovieConverter.convertDtoToEntity(movieRequestDTO, movie);

        return new MovieResponseDTO(movieRepository.save(movie));
    }

    @Transactional
    public MovieResponseDTO update(Long id, MovieRequestDTO movieRequestDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        MovieConverter.convertDtoToEntity(movieRequestDTO, movie);

        return new MovieResponseDTO(movieRepository.save(movie));
    }

    @Transactional
    public void deleteById(Long id) {
        movieRepository.deleteById(movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!")).getId());
    }
}
