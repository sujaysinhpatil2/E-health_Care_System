package com.sujay.ecs.adminservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "FirstName")
	private String firstname;
	@Column(name = "LastName")
	private String lastname;
	@Column(name="UserName")
	private String username;
	@Column(name="Password")
	private String password;
	
	@Column(name="MobileNo")
	private String mobileno;
	@Column(name="City")
	private String city;
	@Column(name="Pincode")
	private String pincode;
	
}
