package com.paranoidal97.ShoppingCartMicroservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ShoppingCartException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
