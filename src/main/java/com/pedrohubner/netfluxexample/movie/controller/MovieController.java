package com.pedrohubner.netfluxexample.movie.controller;

import com.pedrohubner.netfluxexample.movie.MovieService;
import com.pedrohubner.netfluxexample.movie.model.Movie;
import com.pedrohubner.netfluxexample.movie.model.MovieEvent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}/events")
    public Flux<MovieEvent> streamMovieEvent(@PathVariable String id) {
        return movieService.generate(id);
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
