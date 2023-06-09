package com.example.projetospringcompleto.exception;

import lombok.Getter;

@Getter
public enum MessageCode {
    INVALID_REQUEST("INVALID_REQUEST"),
    FIELD_ID_NOT_FOUND("FIELD_ID_NOT_FOUND"),
    CAUSE_FIELD_ID_NOT_FOUND("CAUSE_FIELD_ID_NOT_FOUND"),
    EMPTY_LIST("EMPTY_LIST"),
    CAUSE_EMPTY_LIST("CAUSE_EMPTY_LIST"),
    ORDER_NOT_FOUND("ORDER_NOT_FOUND"),
    CAUSE_ORDER_NOT_FOUND("CAUSE_ORDER_NOT_FOUND"),
    INVALID_FIELD("INVALID_FIELD"),
    CAUSE_INVALID_FIELD("CAUSE_INVALID_FIELD");
    final String value;

    MessageCode(String value) {
        this.value = value;
    }
}
