package com.sujay.ecs.adminservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sujay.ecs.adminservice.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addDoctor(Doctor doctor) {
		Session session = null;
		Boolean isAdded = false;
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(doctor);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
				
		return isAdded;
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
