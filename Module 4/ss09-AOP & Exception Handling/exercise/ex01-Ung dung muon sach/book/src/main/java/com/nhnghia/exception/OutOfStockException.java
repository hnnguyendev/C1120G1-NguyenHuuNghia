package com.nhnghia.exception;

public class OutOfStockException extends Exception {

    public OutOfStockException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
