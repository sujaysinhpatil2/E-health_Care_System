package com.sujay.ecs.AdiminService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sujay.ecs.AdiminService.dao.DoctorDao;
import com.sujay.ecs.AdiminService.entity.Doctor;
import com.sujay.ecs.AdiminService.exception.AdminNotFoundException;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorDao doctorDao;
	
	@PostMapping(value = "/addDoctor")
	public ResponseEntity<Boolean> addDoctor(@RequestBody Doctor doctor){
		
		boolean isAdded = doctorDao.addDoctor(doctor);
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value = "/getDoctorById/{Id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorid){
		
		Doctor doctor = doctorDao.getDoctorById(doctorid);
		if(doctor != null) {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
		}else {
			throw new AdminNotFoundException("Doctor not found for id : " + doctorid);
		}
		
	}

}
