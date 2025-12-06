package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.entity.RegisterEntity;
import com.register_service.RegisterService.mapper.RegisterMapper;
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
    @Override
    public List<String> registerUsers(RegisterDto regDto) {
        List<String> registerResponse = new ArrayList<>();
        regDto.setFirstName(regDto.getFirstName().toUpperCase());
        regDto.setLastName(regDto.getLastName().toUpperCase());
        regDto.setEmail(regDto.getLastName().toLowerCase());
        RegisterEntity regEntity = regMapper.dtoToEntity(regDto);
        boolean b = roleRepo.existsById(regDto.getRoleEntity().getRid());
        if(b){
            registerRepo.save(regEntity);
            registerResponse.add("User " + regDto.getFirstName().toUpperCase() + "Registered Successfully " +
                    "as " + regDto.getRoleEntity().getRoleAssigned());
        }else{
            registerResponse.add("Role Id " + regDto.getRoleEntity().getRid() + "Not Available");
        }
        return registerResponse;
    }
}