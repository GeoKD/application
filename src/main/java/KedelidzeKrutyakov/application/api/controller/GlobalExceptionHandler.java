package KedelidzeKrutyakov.application.api.controller;

import KedelidzeKrutyakov.application.api.DTO.PrescoringExceptionResponse;
import KedelidzeKrutyakov.application.utils.prescoring.PrescoringException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (PrescoringException.class)
    public ResponseEntity<PrescoringExceptionResponse> handlePrescoringException
            (PrescoringException e) {
        return new ResponseEntity<>(e.getPrescoringExceptionResponse(), HttpStatus.OK);
    }
}
