package ru.ovchinnikov.sber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    @NotNull(message = "Поле 'Название фильма' - обязательное")
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "releaseDate", nullable = false)
    @NotNull(message = "Поле 'Дата выхода фильма' - обязательное")
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate releaseDate;
}
