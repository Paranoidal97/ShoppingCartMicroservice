package com.paranoidal97.ShoppingCartMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends ShoppingCartException {
    public DataNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
