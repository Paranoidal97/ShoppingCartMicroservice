package com.paranoidal97.ShoppingCartMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataAlreadyExistException extends ShoppingCartException {
    public DataAlreadyExistException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
