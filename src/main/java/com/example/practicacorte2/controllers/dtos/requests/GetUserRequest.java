package com.example.practicacorte2.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetUserRequest {

    private String email;
    private String password;
}
