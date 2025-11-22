package com.register_service.RegisterService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/show")
    public String showResponse(){
        return "Hello";
    }
}