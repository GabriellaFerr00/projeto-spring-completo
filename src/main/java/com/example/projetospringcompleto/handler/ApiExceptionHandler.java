package com.example.projetospringcompleto.handler;

import com.example.projetospringcompleto.exception.EmptyListException;
import com.example.projetospringcompleto.exception.IdNotFoundException;
import com.example.projetospringcompleto.exception.MessageCode;
import com.example.projetospringcompleto.handler.errors.ApiErrors;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler {

    private ReloadableResourceBundleMessageSource messageBundle;

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handlerIdNotFoundException(IdNotFoundException ex, WebRequest request){
        ApiErrors apiErrors = ApiErrors
                .builder()
                .title(getCodeMessage(MessageCode.INVALID_REQUEST))
                .status(HttpStatus.BAD_REQUEST.value())
                .details(getCodeMessage(MessageCode.FIELD_ID_NOT_FOUND))
                .timestamp(LocalDateTime.now())
                .cause(getCodeMessage(MessageCode.CAUSE_FIELD_ID_NOT_FOUND))
                .build();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ApiErrors> handlerEmptyListException(EmptyListException ex, WebRequest request){
        ApiErrors apiErrors = ApiErrors
                .builder()
                .title(getCodeMessage(MessageCode.INVALID_REQUEST))
                .status(HttpStatus.BAD_REQUEST.value())
                .details(getCodeMessage(MessageCode.EMPTY_LIST))
                .timestamp(LocalDateTime.now())
                .cause(getCodeMessage(MessageCode.CAUSE_EMPTY_LIST))
                .build();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }

    private String getCodeMessage(MessageCode messageCode){
        return messageBundle.getMessage(messageCode.getValue(), null, LocaleContextHolder.getLocale());
    }
}
