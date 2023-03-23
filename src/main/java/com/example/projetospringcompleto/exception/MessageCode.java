package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public enum MessageCode {
    INVALID_REQUEST("INVALID_REQUEST"),
    FIELD_ID_NOT_FOUND("FIELD_ID_NOT_FOUND"),
    CAUSE_FIELD_ID_NOT_FOUND("CAUSE_FIELD_ID_NOT_FOUND"),
    EMPTY_LIST("EMPTY_LIST"),
    CAUSE_EMPTY_LIST("CAUSE_EMPTY_LIST");
    final String value;

    MessageCode(String value) {
        this.value = value;
    }
}
