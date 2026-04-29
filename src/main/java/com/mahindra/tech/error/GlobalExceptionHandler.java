package com.mahindra.tech.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAll(
            Exception ex,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .status(500)
                .body(Map.of(
                        "status", "500",
                        "error", "Internal Server Error",
                        "message", ex.getMessage(),
                        "path", request.getRequestURI()
                ));
    }
}
