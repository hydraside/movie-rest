package ru.ovchinnikov.sber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ovchinnikov.sber.model.MovieGenre;
import ru.ovchinnikov.sber.model.MovieType;
import ru.ovchinnikov.sber.repository.MovieGenreRepository;
import ru.ovchinnikov.sber.repository.MovieRepository;
import ru.ovchinnikov.sber.repository.MovieTypeRepository;

@Configuration
public class LoadDatabase {
    @Autowired
    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository, MovieGenreRepository movieGenreRepository, MovieTypeRepository movieTypeRepository){
        return args -> {
            movieGenreRepository.save(new MovieGenre(0, "Экшн"));
            movieGenreRepository.save(new MovieGenre(0, "Триллер"));
            movieGenreRepository.save(new MovieGenre(0, "Драма"));

            movieTypeRepository.save(new MovieType(0, "Полнометражный"));
            movieTypeRepository.save(new MovieType(0, "Короткометражный"));
            movieTypeRepository.save(new MovieType(0, "Сериал"));
        };
    }
}
