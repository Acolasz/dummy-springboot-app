package hu.kukutyin.dummy.service.app.dao.exception;

public class ConstantsDaoException extends Exception {

    public ConstantsDaoException() {
    }

    public ConstantsDaoException(String message) {
        super(message);
    }

    public ConstantsDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstantsDaoException(Throwable cause) {
        super(cause);
    }

    public ConstantsDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
