package com.register_service.RegisterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
		System.out.println("This is the Register Microservice");
	}
}