package com.sujay.ecs.UserService.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@NonNull
	@Column(name = "FirstName")
	private String firstname;
	@Column(name = "LastName")
	private String lastname;
	@NonNull
	@Column(name="UserName")
	private String username;
	@NonNull
	@Column(name="Password")
	private String password;
	
	@Column(name="MobileNo")
	private String mobileno;
	@Column(name="City")
	private String city;
	@Column(name="Pincode")
	private String pincode;
	
}
