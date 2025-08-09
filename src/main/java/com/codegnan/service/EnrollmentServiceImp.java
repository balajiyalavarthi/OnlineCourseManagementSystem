package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.EnrollmentDaoImp;
import com.codegnan.model.Enrollment;

public class EnrollmentServiceImp implements EnrollmentService{
	
	EnrollmentDaoImp enrollmentImp = new EnrollmentDaoImp();

	@Override
	public String save(Enrollment enrollment) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return enrollmentImp.addEnrollment(enrollment);
	}

	@Override
	public List<Enrollment> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return enrollmentImp.getAllEnrollment();
	}

	@Override
	public Enrollment findById(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return enrollmentImp.getByEnrollmentId(id);
	}

	@Override
	public String update(Enrollment enrollment) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return enrollmentImp.updateByEnrollmentId(enrollment);
	}

	@Override
	public String delete(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return enrollmentImp.deleteByEnrollmentId(id);
	}

}
