package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException{
    final MessageCode messageCode;

    public OrderNotFoundException(MessageCode messageCode){
        this.messageCode = messageCode;
    }
}
