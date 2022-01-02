package com.lelakowski.calculator.exception;

public class InvalidArithmeticMarkException extends RuntimeException {
    public InvalidArithmeticMarkException(String symbol) {
        super("Cannot parse: " + symbol + " to arithmetic symbol."
                + "The available characters are: add, divide, subtract, multiply.");
    }
}
