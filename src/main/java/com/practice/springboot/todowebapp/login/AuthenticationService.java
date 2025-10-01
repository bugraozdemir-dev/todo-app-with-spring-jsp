package com.practice.springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUsername = username.equalsIgnoreCase("bozdemir");
        boolean isValidPassword = password.equalsIgnoreCase("test");

        return  isValidUsername && isValidPassword;
    }
}
