package com.register_service.RegisterService.repository;

import com.register_service.RegisterService.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    boolean existsByRoleAssigned(String roleAssigned);
}