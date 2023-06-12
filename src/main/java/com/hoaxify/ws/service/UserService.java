package com.hoaxify.ws.service;

import com.hoaxify.ws.entity.User;
import com.hoaxify.ws.exception.UsernameAlreadyExistException;
import com.hoaxify.ws.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void save(User user) {
        log.info("Info.save().start username: {}", user.getUsername());

        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistException("username already exist username: " + user.getUsername());
        }

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("Info.save().end user-id: {}", user.getId());
    }
}
