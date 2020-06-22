package com.firstspringapp.exception;

public class UserException extends RuntimeException{
    private USER_ERROR error;

    public enum USER_ERROR {
        NOT_FOUND
    }
    public UserException(USER_ERROR error) {
        this.error = error;
    }
}
