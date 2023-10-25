package ru.ovchinnikov.sber.model;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
