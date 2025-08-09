package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Grades;

public interface GradesDao {

    public String addGrade(Grades grade) throws ClassNotFoundException;

    public List<Grades> getAllGrades() throws ClassNotFoundException;

    public Grades getByGradeId(int id) throws ClassNotFoundException;

    public String updateByGradeId(Grades grades) throws ClassNotFoundException;

    public String deleteByGradeId(int id) throws ClassNotFoundException;

}
