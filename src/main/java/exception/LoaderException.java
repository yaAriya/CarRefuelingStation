package exception;

public class LoaderException extends RuntimeException {
    public LoaderException() {
        super();
    }

    public LoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoaderException(Throwable cause) {
        super(cause);
    }

    protected LoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoaderException(String message) {
        super(message);
    }
}
