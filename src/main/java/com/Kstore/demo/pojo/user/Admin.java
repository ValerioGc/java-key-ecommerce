package com.Kstore.demo.pojo.user;


import org.springframework.util.DigestUtils;

import com.Kstore.demo.interfaces.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Admin implements User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	@Column
	private String userName;
	@Column
	private String password;
	
	public Admin() {}
	
	public Admin(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	protected String getPassword() {
		return password;
	}


	public String setHashPassword(String password) {
		       
        String saltedInput = "GAS83w#" + password;

        // Generate the MD5 hash
        String md5Hash = DigestUtils.md5DigestAsHex(saltedInput.getBytes());

        return md5Hash;
	}
	
	public void setPassword(String password) {

		this.password = setHashPassword(password);
	}

	public int getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return "";
	}
	
}
