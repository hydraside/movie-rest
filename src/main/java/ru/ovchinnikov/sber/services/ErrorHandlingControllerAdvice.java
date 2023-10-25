package ru.ovchinnikov.sber.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.ovchinnikov.sber.model.ValidationErrorResponse;
import ru.ovchinnikov.sber.model.Violation;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintViolationException(ConstraintViolationException ex){
        final List<Violation> violations = ex.getConstraintViolations().stream()
                .map(e -> new Violation(e.getPropertyPath().toString(), e.getMessage()))
                .toList();

        return new ValidationErrorResponse(violations);
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        final List<Violation> violations = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> new Violation(e.getField(), e.getDefaultMessage()))
                .toList();

        return new ValidationErrorResponse(violations);
    }
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ValidationErrorResponse onEntityNotFoundException(EntityNotFoundException ex){
        final List<Violation> violations = new ArrayList<>();
        violations.add(new Violation("Не найдено", "Сущность с id " + ex.getMessage() + " не найдена"));
        return new ValidationErrorResponse(violations);
    }
}
