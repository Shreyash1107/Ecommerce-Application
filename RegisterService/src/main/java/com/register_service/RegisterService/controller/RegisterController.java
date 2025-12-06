package com.register_service.RegisterService.controller;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/saveUsers")
    public ResponseEntity<List<String>> registerUsers(@RequestBody RegisterDto regDto){
        List<String> registerResponse = registerService.registerUsers(regDto);
        if(registerResponse.get(0).contains("Registered Successfully")){
            return ResponseEntity.status(HttpStatus.OK).body(registerResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(registerResponse);
        }
    }
}