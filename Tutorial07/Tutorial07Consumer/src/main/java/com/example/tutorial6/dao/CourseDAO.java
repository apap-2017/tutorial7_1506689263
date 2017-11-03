package com.example.tutorial6.dao;

import java.util.List;

import com.example.tutorial6.model.CourseModel;

public interface CourseDAO {
	
	CourseModel selectCourse(String id_course);
	List<CourseModel> selectAllCourses();
}
