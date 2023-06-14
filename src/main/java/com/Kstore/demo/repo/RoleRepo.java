package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.user.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	List<Role> findByNameContaining(String name);

}
