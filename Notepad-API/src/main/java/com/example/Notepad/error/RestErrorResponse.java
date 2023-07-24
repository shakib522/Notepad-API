package com.example.Notepad.error;

import com.example.Notepad.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class RestErrorResponse extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorMessage> defaultException(DefaultException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                "Failed",
                exception.getMessage(),
                exception.getStatus()
        );

        return ResponseEntity.status(exception.getStatus())
                .body(message);
    }
}
