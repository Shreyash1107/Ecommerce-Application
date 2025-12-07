package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.repository.RegisterRepository;
import com.register_service.RegisterService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService{
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private RegisterRepository registerRepo;
    @Override
    public List<String> validateRole(RoleDto roleDto) {
        List<String> roleErrors = new ArrayList<>();
       if(roleDto == null || roleDto.getRoleAssigned().trim().isEmpty()){
            roleErrors.add("Please Provide Role");
        }if(roleDto!=null){
           if(roleRepo.existsByRoleAssigned(roleDto.getRoleAssigned())){
               roleErrors.add("Role " + roleDto.getRoleAssigned() + " Already Exists");
           }
        }
        return roleErrors.isEmpty() ? List.of() : roleErrors;
    }

    @Override
    public List<String> validateRegistration(RegisterDto registerDto) {
        List<String> validateRegisteredUser = new ArrayList<>();
        if(registerDto==null){
            validateRegisteredUser.add("All Fields are required");
        }if(registerDto!=null){
            if(registerDto.getFirstName().trim().isEmpty()){
                validateRegisteredUser.add("First Name is Required");
            }if(registerDto.getLastName().trim().isEmpty()){
                validateRegisteredUser.add("Last Name is Required");
            }if(registerDto.getEmail().trim().isEmpty()){
                validateRegisteredUser.add("Email is Required");
            }if(registerDto.getContact().trim().isEmpty()){
                validateRegisteredUser.add("Password is Required");
            }if(registerDto.getPassword().trim().isEmpty()){
                validateRegisteredUser.add("Password is Required");
            }if(registerDto.getConfirmPassword().trim().isEmpty()){
                validateRegisteredUser.add("Confirm Password is Required");
            }if(registerDto.getRoleEntity().getRid()==0){
                validateRegisteredUser.add("Provide Role Details");
            }if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
                validateRegisteredUser.add("Passwords Should Match");
            }
            boolean emailExists = registerRepo.existsByEmail(registerDto.getEmail());
            boolean contactExists = registerRepo.existsByContact(registerDto.getContact());
            boolean passwordExists = registerRepo.existsByPassword(registerDto.getPassword());
            if(emailExists){
                validateRegisteredUser.add("Email " + registerDto.getEmail() + "Already Exists");
            }if(contactExists){
                validateRegisteredUser.add("Contact " + registerDto.getContact() + "Already Exists");
            }if(passwordExists){
                validateRegisteredUser.add("Password " + registerDto.getPassword() + "Already Exists");
            }
        }
        return validateRegisteredUser;
    }
}