package com.example.tutorial6.service;

import java.util.List;

import com.example.tutorial6.model.StudentModel;

public interface StudentService {
	StudentModel selectStudent(String npm);
	
	List<StudentModel> selectAllStudents();
	
	void addStudent(StudentModel student);
	
	void deleteStudent(String npm);
	
	void updateStudent(StudentModel student);
	
	void addCourse(String npm, String idCourse);
	
}
