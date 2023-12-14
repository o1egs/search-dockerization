package ru.shtyrev.searchservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@Data
public class ESProjectException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
