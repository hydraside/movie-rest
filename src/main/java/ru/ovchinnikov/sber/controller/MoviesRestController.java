package ru.ovchinnikov.sber.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ovchinnikov.sber.model.AppResponse;
import ru.ovchinnikov.sber.model.Movie;
import ru.ovchinnikov.sber.repository.MovieRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api", produces = "application/json")
public class MoviesRestController {
    private final MovieRepository movieRepository;
    @Autowired
    public MoviesRestController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @GetMapping("/movie")
    public ResponseEntity<?> getMovies(){
        List<Movie> movies = (List<Movie>)movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable int id) throws EntityNotFoundException {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("" + id));
        return ResponseEntity.ok(movie);
    }
    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@Valid @RequestBody Movie movie){
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }
    @PutMapping("/movie")
    public ResponseEntity<?> updateMovie(@PathVariable int id, @Valid @RequestBody Movie model) throws EntityNotFoundException{
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("" + id));
        model.setId(id);
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> removeMovie(@PathVariable  int id){
        movieRepository.deleteById(id);
        return ResponseEntity.ok(new AppResponse("Сущность с Id " + id + " была удалена!"));
    }
}
