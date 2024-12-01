package hu.nje.naplo.controller;

import hu.nje.naplo.controller.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice(basePackages = "hu.nje.naplo.controller.rest")
public class GlobalRestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .timestamp(new Date())
                        .error("Resource not found")
                        .message(ex.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(new Date())
                        .error("Internal Server Error")
                        .message("Something went wrong")
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorResponse {
        private Date timestamp;
        private int status;
        private String error;
        private String message;
    }
}
