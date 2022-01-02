package com.lelakowski.calculator.exception;

public class NotFoundApplyMarkException extends RuntimeException {
    public NotFoundApplyMarkException(String symbol) {
        super("Last arithmetic symbol should be: Apply. Current last arithmetic symbol: "+symbol);
    }
}
