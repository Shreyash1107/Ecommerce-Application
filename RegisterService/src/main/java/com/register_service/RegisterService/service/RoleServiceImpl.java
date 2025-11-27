package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.entity.RoleEntity;
import com.register_service.RegisterService.mapper.RoleMapper;
import com.register_service.RegisterService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<String> saveRoles(RoleDto roleDto) {
        List<String> response = new ArrayList<>();
        RoleEntity roleEntity = roleMapper.dtoToEntity(roleDto);
        roleEntity.setRoleAssigned(roleEntity.getRoleAssigned().toUpperCase());
        roleRepo.save(roleEntity);
        response.add("Role " + roleDto.getRoleAssigned() + " Saved Successfully");
        return response;
    }
}