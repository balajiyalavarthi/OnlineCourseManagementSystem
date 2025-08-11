package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Course;

public interface CourseDao {

    String addCourse(Course course) throws ClassNotFoundException;

    List<Course> getAllCourses() throws ClassNotFoundException;

    Course getByCourseId(int courseId) throws ClassNotFoundException;

    String updateByCourseName(Course course) throws ClassNotFoundException;

    String deleteByCourseName(String courseName) throws ClassNotFoundException;

    // Add this method for instructor-specific courses
    List<Course> findCoursesByInstructor(int instructorId) throws ClassNotFoundException;
}
