package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Enrollment;

public interface EnrollmentService {

	public String save(Enrollment enrollment) throws ClassNotFoundException;

    public List<Enrollment> findAll() throws ClassNotFoundException;

    public Enrollment findById(int id) throws ClassNotFoundException;

    public String update(Enrollment enrollment) throws ClassNotFoundException;

    public String delete(int id) throws ClassNotFoundException;


}
