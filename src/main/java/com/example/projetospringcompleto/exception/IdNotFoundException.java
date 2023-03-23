package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public class IdNotFoundException extends RuntimeException{
    final MessageCode messageCode;

    public IdNotFoundException(MessageCode messageCode){
        this.messageCode = messageCode;
    }
}
