package com.movie.movieapi.repository;

import com.movie.movieapi.entity.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM tb_movie m WHERE m.name like %?%", nativeQuery = true)
    List<Movie> findByName(String name);

    @Query(value = "SELECT obj FROM Movie obj JOIN FETCH obj.category")
    List<Movie> searchAll();

    @Query(value = "SELECT obj FROM Movie obj JOIN FETCH obj.category")
    List<Movie> searchAll(Sort name);
}
