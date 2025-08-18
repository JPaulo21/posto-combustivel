package com.jp.posto_combustivel.web.exception;

import com.jp.posto_combustivel.domain.exceptions.BusinessException;
import com.jp.posto_combustivel.domain.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApiControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ApiControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(HttpServletRequest request, Exception ex){
        log.error("Internal server error: {}", ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(new ErrorResponse(
                LocalDateTime.now(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                request.getRequestURI(),
                ex.getMessage())
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(HttpServletRequest request, BusinessException ex) {
        log.error("Business exception: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponse(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                request.getRequestURI(),
                ex.getMessage())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
        log.error("Not found exception: {}", ex.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(
                LocalDateTime.now(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                request.getRequestURI(),
                ex.getMessage())
        );
    }
}
