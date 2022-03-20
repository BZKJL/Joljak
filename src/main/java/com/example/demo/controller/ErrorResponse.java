package com.example.demo.controller;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value(staticConstructor = "with")
public class ErrorResponse {
    int httpCode;
    String reason;

    public static ErrorResponse with404(String reason){
        return ErrorResponse.with(HttpStatus.NOT_FOUND.value(),reason);

    }

    public static ErrorResponse with500(String reason) {
        return ErrorResponse.with(HttpStatus.INTERNAL_SERVER_ERROR.value(),reason);
    }
}
