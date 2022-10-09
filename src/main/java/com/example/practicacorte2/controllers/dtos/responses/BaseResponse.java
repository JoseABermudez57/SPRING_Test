package com.example.practicacorte2.controllers.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder @Getter
public class BaseResponse {
    // Todos los objetos dentro de java heredan de la clase Object
    private Object data;
    private String message;
    private Boolean success; // Si la transaccion del frontend fue exitosa
    private HttpStatus httStatus;

}
