package com.pedrohubner.netfluxexample.movie.repository;

import com.pedrohubner.netfluxexample.movie.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
