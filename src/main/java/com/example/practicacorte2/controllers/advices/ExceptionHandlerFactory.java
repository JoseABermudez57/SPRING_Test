package com.example.practicacorte2.controllers.advices;

import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.OperationNotSupportedException;

@ControllerAdvice
public class ExceptionHandlerFactory {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BaseResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        // En los errores no se envía la data
        BaseResponse errorResponse = BaseResponse.builder()
                .message(exception.getLocalizedMessage())
                .success(false)
                .httStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttStatus());
    }

    @ExceptionHandler(OperationNotSupportedException.class)
    private ResponseEntity<BaseResponse> handleOperationNotSupportedException(OperationNotSupportedException exception) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(exception.getLocalizedMessage())
                .success(false)
                .httStatus(HttpStatus.CONFLICT)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttStatus());
    }

}