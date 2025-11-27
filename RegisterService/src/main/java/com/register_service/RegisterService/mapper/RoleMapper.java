package com.register_service.RegisterService.mapper;

import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    @Autowired
    private ModelMapper modelMapper;
    public RoleEntity dtoToEntity(RoleDto roleDto){
        return modelMapper.map(roleDto,RoleEntity.class);
    }
    public RoleDto entityToDto(RoleEntity roleEntity){
        return modelMapper.map(roleEntity,RoleDto.class);
    }
}