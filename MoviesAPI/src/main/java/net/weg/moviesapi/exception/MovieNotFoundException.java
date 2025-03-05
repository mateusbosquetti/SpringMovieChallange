package net.weg.moviesapi.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
