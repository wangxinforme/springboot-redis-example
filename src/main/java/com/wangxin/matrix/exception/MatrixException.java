package com.wangxin.matrix.exception;

public class MatrixException extends RuntimeException {
    private static final long serialVersionUID = -5563106933655728813L;

    public MatrixException() {
        super();
    }

    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }
}