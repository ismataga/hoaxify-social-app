package com.hoaxify.ws.controller;

import com.hoaxify.ws.entity.User;
import com.hoaxify.ws.exception.handle.ApiError;

import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/1.0/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse create(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User created");
    }
}
