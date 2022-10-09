package com.example.practicacorte2.services;

import com.example.practicacorte2.controllers.dtos.requests.GetUserRequest;
import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import com.example.practicacorte2.controllers.dtos.responses.GetUserResponse;
import com.example.practicacorte2.entities.User;
import com.example.practicacorte2.repositories.IUserRepository;
import com.example.practicacorte2.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override // Modificar el retorno a un BaseResponse
    public BaseResponse create(GetUserRequest request) {
        User save = repository.save(from(request));

        // Aquí cae cuando las cosas salen bien
        // Se devuelve el BaseResponse con información más detallada
        return BaseResponse.builder()
                .data(from(save))
                .message("User created correctly")
                .success(Boolean.TRUE)
                .httStatus(HttpStatus.CREATED).build();
    }

    @Override
    public GetUserResponse get(Long id) {
        User user = findAndEnsureExist(id); // Esto es un user
        return from(user);
    }

    @Override
    public List<GetUserResponse> list() {
        return repository.findAll().stream()
                .map(user -> from(user))
                .collect(Collectors.toList());
    }

    @Override
    public GetUserResponse update(Long id, GetUserRequest request) {
        User user = findAndEnsureExist(id);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return from(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    ;

    // Retorno de una respuesta
    private GetUserResponse from(User user){
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    };

    // Retorno de un User
    private User from(GetUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    // Se asegura de que exista
    private User findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    };
}
