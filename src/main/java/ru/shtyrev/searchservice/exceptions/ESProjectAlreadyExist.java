package ru.shtyrev.searchservice.exceptions;

public class ESProjectAlreadyExist extends Exception {
    public ESProjectAlreadyExist() {
        super();
    }

    public ESProjectAlreadyExist(String message) {
        super(message);
    }

    public ESProjectAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public ESProjectAlreadyExist(Throwable cause) {
        super(cause);
    }

    protected ESProjectAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
