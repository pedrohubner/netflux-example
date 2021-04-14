package com.pedrohubner.netfluxexample.movie;

import com.pedrohubner.netfluxexample.movie.model.Movie;
import com.pedrohubner.netfluxexample.movie.model.MovieEvent;
import com.pedrohubner.netfluxexample.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Flux<MovieEvent> generate(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
