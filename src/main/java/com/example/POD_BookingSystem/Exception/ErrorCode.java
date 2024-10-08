package com.example.POD_BookingSystem.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Invalid message key", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least 3 characters",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission",HttpStatus.FORBIDDEN),
    ID_NOT_FOUND(1008, "ID is not existed or not available", HttpStatus.NOT_FOUND),
    NAME_NOT_FOUND(1009, "Wrong name or name is not existed", HttpStatus.NOT_FOUND),
    INVALID_DATE_RANGE(1010,"Invalid date range",HttpStatus.NOT_FOUND),
//    ROOM_NOT_AVAILABLE(1011,"Room not available",HttpStatus.NOT_FOUND)
    ;

    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

}