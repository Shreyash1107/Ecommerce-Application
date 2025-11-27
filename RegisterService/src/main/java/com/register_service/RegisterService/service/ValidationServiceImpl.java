package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService{
    @Autowired
    private RoleRepository roleRepo;
    @Override
    public List<String> validateRole(RoleDto roleDto) {
        List<String> roleErrors = new ArrayList<>();
       if(roleDto == null || roleDto.getRoleAssigned().trim().isEmpty()){
            roleErrors.add("Please Provide Role");
        }if(roleDto!=null){
           if(roleRepo.existsByRoleAssigned(roleDto.getRoleAssigned())){
               roleErrors.add("Role " + roleDto.getRoleAssigned() + "Already Exists");
           }
        }
        return List.of();
    }
}