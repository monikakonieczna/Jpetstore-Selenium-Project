package com.jpetstore.exceptions;

public class InputDataException extends AssertionError {

    public InputDataException(String message) {
        super(createMessage(message));
    }

    private static String createMessage(String message) {
        return message == null ? "" : message;
    }
}
