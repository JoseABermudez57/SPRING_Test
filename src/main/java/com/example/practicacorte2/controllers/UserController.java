package com.example.practicacorte2.controllers;

import com.example.practicacorte2.controllers.dtos.requests.GetUserRequest;
import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import com.example.practicacorte2.controllers.dtos.responses.GetUserResponse;
import com.example.practicacorte2.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("{id}")
    public GetUserResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<GetUserResponse> list() {
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping // Con la notacion @Valid valida lo que esten en las notaciones del request
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid GetUserRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttStatus());
    }

    @PutMapping
    public GetUserResponse update(@PathVariable Long id,@RequestBody GetUserRequest request) {
        return service.update(id, request);
    }
}
