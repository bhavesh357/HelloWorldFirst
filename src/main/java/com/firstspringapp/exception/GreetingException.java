package com.firstspringapp.exception;

public class GreetingException extends RuntimeException {

    private GREETING_ERROR error;
    public GreetingException(GREETING_ERROR error) {
        this.error = error;
    }

    public enum GREETING_ERROR {
        NOT_FOUND
    }
}
