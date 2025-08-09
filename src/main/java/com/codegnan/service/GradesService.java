package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Grades;

public interface GradesService {

		public String save(Grades grade) throws ClassNotFoundException;

	    public List<Grades> findAll() throws ClassNotFoundException;

	    public Grades finById(int id) throws ClassNotFoundException;

	    public String update(Grades grades) throws ClassNotFoundException;

	    public String delete(int id) throws ClassNotFoundException;
}
