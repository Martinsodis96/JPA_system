package se.soderstrand.martin.exception;

public final class RepositoryException extends Exception {

    private static final long serialVersionUID = -6804986646778612047L;

    public RepositoryException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RepositoryException(String message) {
        super(message);
    }
}
