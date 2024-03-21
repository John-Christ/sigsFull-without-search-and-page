package sigs.api.exception;

public class RestApiNotFoundException extends RuntimeException {

    public RestApiNotFoundException(Long id) {
        super("Could not find sigs " + id);
    }
}
