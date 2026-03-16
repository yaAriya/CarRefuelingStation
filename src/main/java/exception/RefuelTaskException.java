package exception;

public class RefuelTaskException extends Exception {
    public RefuelTaskException() {
        super();
    }

    public RefuelTaskException(String message) {
        super(message);
    }

    public RefuelTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefuelTaskException(Throwable cause) {
        super(cause);
    }

    protected RefuelTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
