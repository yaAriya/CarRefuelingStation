package exception;

public class RefuellingException extends Exception {
    public RefuellingException() {
        super();
    }

    public RefuellingException(String message) {
        super(message);
    }

    public RefuellingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefuellingException(Throwable cause) {
        super(cause);
    }

    protected RefuellingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
