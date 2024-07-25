package com.sujay.ecs.adminservice.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sujay.ecs.adminservice.entity.Doctor;

public interface DoctorDao {
	
	boolean addDoctor(Doctor doctor);
	
	@Query("select a from Doctor a where a.id=:ids")
	Doctor getDoctorById(@Param("ids") int id);

}
