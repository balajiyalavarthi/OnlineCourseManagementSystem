package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Enrollment;

public interface EnrollmentDao {

    public String addEnrollment(Enrollment enrollment) throws ClassNotFoundException;

    public List<Enrollment> getAllEnrollment() throws ClassNotFoundException;

    public Enrollment getByEnrollmentId(int id) throws ClassNotFoundException;

    public String updateByEnrollmentId(Enrollment enrollment) throws ClassNotFoundException;

    public String deleteByEnrollmentId(int id) throws ClassNotFoundException;

}
