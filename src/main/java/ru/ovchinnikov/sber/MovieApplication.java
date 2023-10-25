package ru.ovchinnikov.sber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import ru.ovchinnikov.sber.model.Movie;
import ru.ovchinnikov.sber.repository.MovieRepository;

import java.util.List;

@SpringBootApplication
@ComponentScan
public class MovieApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}
