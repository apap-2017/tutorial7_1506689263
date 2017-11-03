package com.example.tutorial6.service;

import java.util.List;

import com.example.tutorial6.model.CourseModel;

public interface CourseService {
	
	CourseModel selectCourse(String id_course);
	List<CourseModel> selectAllCourses();
}
