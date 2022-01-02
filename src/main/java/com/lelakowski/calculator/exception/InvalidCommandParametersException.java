package com.lelakowski.calculator.exception;

public class InvalidCommandParametersException extends RuntimeException {
    public InvalidCommandParametersException(String command) {
        super("Command: " + command + " contains an incorrect number of parameters. " +
                "The command should contain two parameters: operations and value.");
    }
}
