package com.example.practicacorte2.services.interfaces;

import com.example.practicacorte2.controllers.dtos.requests.GetUserRequest;
import com.example.practicacorte2.controllers.dtos.responses.GetUserResponse;

import java.util.List;

public interface IUserService {
    GetUserResponse get(Long id);

    List<GetUserResponse> list();

    void delete(Long id);

    GetUserResponse create(GetUserRequest request);

    GetUserResponse update(Long id, GetUserRequest request);
}
