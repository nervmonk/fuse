package com.btsk.fuseintegration.fuse_integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { BadRequestException.class })
    public ResponseEntity<Object> processException(BadRequestException e) {
        log.info("Exception is BadRequestException, message : {}", e.getMessage());

        return new ResponseEntity<>(new ErrorDetail(e.getMessage(), e.getCode(), e.getError(), e.getLatency()),
                HttpStatus.BAD_REQUEST);
    }
}
