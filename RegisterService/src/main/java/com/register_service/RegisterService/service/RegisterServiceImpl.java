package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.entity.RegisterEntity;
import com.register_service.RegisterService.exception.ResourceNotFoundException;
import com.register_service.RegisterService.mapper.RegisterMapper;
import com.register_service.RegisterService.mapper.RoleMapper;
import com.register_service.RegisterService.repository.RegisterRepository;
import com.register_service.RegisterService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterRepository registerRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private RegisterMapper regMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ValidationService validService;
    @Override
    public List<String> registerUsers(RegisterDto regDto) {
        List<String> registerResponse = new ArrayList<>();
        List<String> registerUserValidations = validService.validateRegistration(regDto);
        if(!registerUserValidations.isEmpty()){
            return registerUserValidations;
        }else{
            regDto.setFirstName(regDto.getFirstName().toUpperCase());
            regDto.setLastName(regDto.getLastName().toUpperCase());
            regDto.setEmail(regDto.getEmail().toLowerCase());
            RegisterEntity regEntity = regMapper.dtoToEntity(regDto);
            RoleDto rolesAssigned = roleRepo.findById(regDto.getRoleEntity().getRid())
                    .map(roleMapper::entityToDto)
                    .orElseThrow(()->new ResourceNotFoundException("Role with Id " +
                            regDto.getRoleEntity().getRid() + " is Not Available"));
            registerRepo.save(regEntity);
            registerResponse.add("User " + regDto.getFirstName().toUpperCase() + " Registered Successfully " +
                    "as " + rolesAssigned.getRoleAssigned());
            return registerResponse;
        }
    }
}