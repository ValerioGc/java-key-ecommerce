package com.Kstore.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kstore.demo.pojo.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByUserNameContaining(String userName);

}
