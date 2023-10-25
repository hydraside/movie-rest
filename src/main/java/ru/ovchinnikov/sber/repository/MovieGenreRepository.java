package ru.ovchinnikov.sber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ovchinnikov.sber.model.Movie;
import ru.ovchinnikov.sber.model.MovieGenre;

@Repository
public interface MovieGenreRepository extends CrudRepository<MovieGenre, Integer> {
}
