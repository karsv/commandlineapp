package com.dev.service;

public class NoResultException extends RuntimeException {
    public NoResultException(String message) {
        super(message);
    }
}
