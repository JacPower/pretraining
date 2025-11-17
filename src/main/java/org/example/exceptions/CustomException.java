package org.example.exceptions;

public class CustomException extends Exception {

    private String errorCode;



    // Constructor with message
    public CustomException(String message) {
        super(message);
    }



    // Constructor with message and cause
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }



    // Constructor with message and error code
    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }



    // Constructor with all parameters
    public CustomException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }



    public String getErrorCode() {
        return errorCode;
    }


    @Override
    public String toString() {
        if (errorCode != null) {
            return "CustomException [" + errorCode + "]: " + getMessage();
        }
        return "CustomException: " + getMessage();
    }
}


class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }



    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

