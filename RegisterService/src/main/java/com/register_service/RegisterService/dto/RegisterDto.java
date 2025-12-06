package com.register_service.RegisterService.dto;

import com.register_service.RegisterService.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String password;
    private String confirmPassword;
    private RoleEntity roleEntity;
}