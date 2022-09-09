package com.flight.api.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ApiError {
    String timestamp;
    HttpStatus status;
    String message;
    String path;

    public ApiError( HttpStatus status, String message, String path) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
