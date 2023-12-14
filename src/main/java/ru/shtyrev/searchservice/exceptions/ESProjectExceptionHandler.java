package ru.shtyrev.searchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ESProjectExceptionHandler {

    @ExceptionHandler(value = ESProjectNotFound.class)
    public ResponseEntity<Object> handleException(ESProjectNotFound e) {

        ESProjectException exception =
                new ESProjectException(e.getMessage(),
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
