package com.assignment.test.exceptionhandling;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}