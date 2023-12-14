package ru.shtyrev.searchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ESProjectExceptionHandler {

    @ExceptionHandler(value = ESProjectNotFound.class)
    public ResponseEntity<Object> handleESProjectNotFoundException(ESProjectNotFound e) {

        ESProjectException exception =
                new ESProjectException(e.getMessage(),
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ESProjectException exception =
                new ESProjectException(e.getMessage(),
                        HttpStatus.BAD_REQUEST,
                        ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<Object> handleNotFoundError(NoHandlerFoundException e) {
//        ESProjectException exception =
//                new ESProjectException(e.getMessage(),
//                        HttpStatus.NOT_FOUND,
//                        ZonedDateTime.now(ZoneId.of("Z")));
//        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
//    }
}
