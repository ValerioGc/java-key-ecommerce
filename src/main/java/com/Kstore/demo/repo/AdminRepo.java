package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.user.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	List<Admin> findByUserNameContaining(String userName);

}
