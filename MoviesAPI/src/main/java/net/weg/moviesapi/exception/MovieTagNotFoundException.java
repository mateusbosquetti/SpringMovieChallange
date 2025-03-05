package net.weg.moviesapi.exception;

public class MovieTagNotFoundException extends RuntimeException{

    public MovieTagNotFoundException() {
        super();
    }

    public MovieTagNotFoundException(String message) {
        super(message);
    }
}
