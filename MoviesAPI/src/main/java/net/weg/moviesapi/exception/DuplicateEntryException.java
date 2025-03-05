package net.weg.moviesapi.exception;

public class DuplicateEntryException extends RuntimeException{

    public DuplicateEntryException() {
        super();
    }

    public DuplicateEntryException(String message) {
        super(message);
    }
}
