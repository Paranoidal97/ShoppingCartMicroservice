package com.paranoidal97.ShoppingCartMicroservice.exception;

import org.springframework.http.HttpStatus;

public class OrderAlreadyPaidException extends ShoppingCartException {
    public OrderAlreadyPaidException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
