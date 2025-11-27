package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<String> saveRoles(RoleDto roleDto);
}