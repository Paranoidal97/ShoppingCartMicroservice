package com.paranoidal97.ShoppingCartMicroservice.exception;

import org.springframework.http.HttpStatus;

public class IllegalApointmentTransition extends ShoppingCartException{
    public IllegalApointmentTransition(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
