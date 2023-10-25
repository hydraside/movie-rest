package ru.ovchinnikov.sber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ovchinnikov.sber.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
