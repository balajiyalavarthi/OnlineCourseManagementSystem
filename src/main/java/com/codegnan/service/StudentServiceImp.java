package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.StudentDao;
import com.codegnan.dao.StudentDaoImp;
import com.codegnan.model.StudentsDetails;

public class StudentServiceImp implements StudentService{
	
	StudentDao student = new StudentDaoImp();

	@Override
	public String save(StudentsDetails studentsDetails) {
		
		return student.addStudent(studentsDetails);
	}

	@Override
	public List<StudentsDetails> findAll() {
		
		return student.getAllStudents();
	}

	@Override
	public StudentsDetails findById(int studentId) {
		
		return student.getByStudentId(studentId);
	}

	@Override
	public String update(StudentsDetails studentDetails) {
		
		return student.updateStudent(studentDetails);
	}

	@Override
	public String deleteById(int studentId) {

		return student.deleteStudentById(studentId);
	}


}
