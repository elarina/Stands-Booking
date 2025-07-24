package com.larina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larina.model.Role;
@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

}
