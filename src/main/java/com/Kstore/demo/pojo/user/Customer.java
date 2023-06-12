package com.Kstore.demo.pojo.user;

import java.time.LocalDate;

import org.springframework.util.DigestUtils;

import com.Kstore.demo.interfaces.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer implements User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column
	private String name;
	
	@Column
	private String userName;
	
	@Column
	private String surname;
	
	@Column
	private String address;
	
	@Column
	private LocalDate birthDate;
	
	@Column
	private String password;
	
	
	
// 	Constructors -----------------------------------------------------------------------
	public Customer() {}
	
	public Customer(String userName, String password) {
		setUserName(userName);
		setPassword(password);
	}

	public Customer(String name, 
					String surname, 
					String address, 
					String userName,
					String birthDate,
					String password) 
				{
		setPassword(password);
		setName(name);
		setSurname(surname);
		setAddress(address);
		setBirthDate(birthDate);
	}
	
	
// 	Getters & Setters ------------------------------------------------------------------
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserName() {
		return address;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
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
	
	
	
//  Custom Override ---------------------------------------------------------------
	@Override
	public String toString(){
		return "Nome: " + getName() + "\nCognome: " + getSurname();
	}
}
