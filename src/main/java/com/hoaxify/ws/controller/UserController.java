package com.hoaxify.ws.controller;

import com.hoaxify.ws.entity.User;
import com.hoaxify.ws.repository.UserRepository;
import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api/1.0/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse create(@RequestBody User user) {
        userService.save(user);
      return new GenericResponse("Response created");
    }

}
