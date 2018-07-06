package com.github.project.repository;


import com.github.project.model.Role;
import com.github.project.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findOneByName(String name);
}
