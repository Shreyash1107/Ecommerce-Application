package com.register_service.RegisterService.service;

import com.register_service.RegisterService.dto.RegisterDto;
import com.register_service.RegisterService.entity.RegisterEntity;
import com.register_service.RegisterService.mapper.RegisterMapper;
import com.register_service.RegisterService.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterRepository registerRepo;
    @Autowired
    private RegisterMapper regMapper;
    @Override
    public List<String> registerUsers(RegisterDto regDto) {
        List<String> registerResponse = new ArrayList<>();
        RegisterEntity regEntity = regMapper.dtoToEntity(regDto);
        return List.of();
    }
}