package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.GradesDao;
import com.codegnan.dao.GradesDaoImp;
import com.codegnan.model.Grades;

public class GradesServiceImp implements GradesService{

	GradesDao gradesImp = new GradesDaoImp();
	
	@Override
	public String save(Grades grade) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradesImp.addGrade(grade);
	}

	@Override
	public List<Grades> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradesImp.getAllGrades();
	}

	@Override
	public Grades finById(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradesImp.getByGradeId(id);
	}

	@Override
	public String update(Grades grades) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradesImp.updateByGradeId(grades);
	}

	@Override
	public String delete(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return gradesImp.deleteByGradeId(id);
	}

}
