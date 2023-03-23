package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException{
    final MessageCode messageCode;

    public EmptyListException(MessageCode messageCode){
        this.messageCode = messageCode;
    }
}
