package com.example.POD_BookingSystem.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(9999, "UNCATGORIZED Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    ID_NOT_FOUND(1001, "ID is not existed or not available", HttpStatus.NOT_FOUND),
    NAME_NOT_FOUND(1002, "Wrong name or name is not existed", HttpStatus.NOT_FOUND),;

    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

}
