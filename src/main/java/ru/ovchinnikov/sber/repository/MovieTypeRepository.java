package ru.ovchinnikov.sber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ovchinnikov.sber.model.Movie;
import ru.ovchinnikov.sber.model.MovieType;

@Repository
public interface MovieTypeRepository extends CrudRepository<MovieType, Integer> {
}
