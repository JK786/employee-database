package com.demo.commons;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Log4j2
class RestCustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> intercept(Exception ex) {

        if (ex instanceof IllegalArgumentException) {
            log.warn(ex, ex);
            return ResponseEntity.status(400).body(ex.getMessage());
        }

        log.error(ex, ex);
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
