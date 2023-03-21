package com.example.projetospringcompleto.exception;

public class BussinessRuleException extends RuntimeException{
    public BussinessRuleException(String message) {
        super(message);
    }
}
