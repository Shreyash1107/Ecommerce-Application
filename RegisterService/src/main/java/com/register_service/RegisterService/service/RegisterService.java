package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RegisterDto;

import java.util.List;

public interface RegisterService {
    List<String> registerUsers(RegisterDto regDto);
}
