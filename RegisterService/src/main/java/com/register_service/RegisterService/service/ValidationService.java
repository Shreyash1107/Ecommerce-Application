package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RoleDto;
import java.util.List;

public interface ValidationService {
    List<String> validateRole(RoleDto roleDto);
}