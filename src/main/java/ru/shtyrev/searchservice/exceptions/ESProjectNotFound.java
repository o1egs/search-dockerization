package ru.shtyrev.searchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ESProjectNotFound extends Exception {
    public ESProjectNotFound() {
        super();
    }

    public ESProjectNotFound(String message) {
        super(message);
    }

    public ESProjectNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ESProjectNotFound(Throwable cause) {
        super(cause);
    }

    protected ESProjectNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
