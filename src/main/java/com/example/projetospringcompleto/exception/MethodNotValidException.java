package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public class MethodNotValidException extends RuntimeException{
    final MessageCode messageCode;

    public MethodNotValidException(MessageCode messageCode){
        this.messageCode = messageCode;
    }
}
