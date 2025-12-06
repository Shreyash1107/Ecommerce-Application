package com.register_service.RegisterService.controller;

import com.register_service.RegisterService.dto.RoleDto;
import com.register_service.RegisterService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping(path = "/saveRoles")
    public ResponseEntity<List<String>> saveRoles(@RequestBody RoleDto roleDto){
        List<String> roleResponse = roleService.saveRoles(roleDto);
        if(roleResponse.get(0).contains("Saved Successfully")){
            return ResponseEntity.status(HttpStatus.OK).body(roleResponse);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(roleResponse);
        }
    }
    @GetMapping("/viewRoleById/{rid}")
    public ResponseEntity<RoleDto> viewRolesById(@PathVariable Integer rid){
        RoleDto rolesByRid = roleService.rolesByRid(rid);
        return ResponseEntity.status(HttpStatus.OK).body(rolesByRid);
    }
}