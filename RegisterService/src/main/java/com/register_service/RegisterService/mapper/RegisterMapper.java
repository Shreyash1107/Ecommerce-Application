package com.register_service.RegisterService.mapper;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.entity.RegisterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    @Autowired
    private ModelMapper modelMapper;
    public RegisterEntity dtoToEntity(RegisterDto registerDto){
        return null;
    }
}