package com.example.musify.exception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ApiError {
    private LocalDateTime timeStamp;
    private HttpStatus errorCode;
    private List<String> errorMessages;
    private UUID errorId;

    public ApiError() {
    }


    public ApiError(HttpStatus errorCode, List<String> errorMessages) {
        this.timeStamp = LocalDateTime.now();
        this.errorCode = errorCode;
        if (this.errorMessages == null) {
            this.errorMessages = new ArrayList<>();
        }
        errorMessages.forEach(error -> this.errorMessages.add(error));


    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public void setErrorId(UUID errorId) {
        this.errorId = errorId;
    }
}
