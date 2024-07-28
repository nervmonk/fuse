package com.btsk.fuseintegration.fuse_integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Getter
public class BadRequestException extends RuntimeException {
    private final String message;
    private final String code;
    private final String error;
    private final String latency;
    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestException(String message, String code, String error, String latency) {
        super(message);
        this.message = message;
        this.code = code;
        this.error = error;
        this.latency = latency;
    }
}
