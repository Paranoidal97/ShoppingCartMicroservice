package com.paranoidal97.ShoppingCartMicroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public abstract class ShoppingCartException extends RuntimeException {
    private final HttpStatus status;

    public ShoppingCartException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
