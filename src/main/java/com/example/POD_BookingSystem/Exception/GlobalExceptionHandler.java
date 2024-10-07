package com.example.POD_BookingSystem.exception;

import com.example.POD_BookingSystem.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){

        ApiResponse apiResponse= new ApiResponse();
        log.info(exception.getMessage());
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)     //bat loi exception
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){

        ErrorCode errorCode=exception.getErrorCode(); //lay ErrorCode ra
        ApiResponse apiResponse= new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<ApiResponse> handlingAccessDeniedException(AccessDeniedException accessDeniedException){
        ErrorCode errorCode=ErrorCode.UNAUTHORIZED;
        return ResponseEntity.status(errorCode.getStatusCode()).body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)   //Bat loi validate
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
        String enumKey=exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode=ErrorCode.INVALID_KEY;   //bat loi invalid key
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){

        }

        ApiResponse apiResponse= new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}