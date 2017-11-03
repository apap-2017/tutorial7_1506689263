package com.example.tutorial6.dao;

import java.util.List;

import com.example.tutorial6.model.StudentModel;

public interface StudentDAO {
	
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudents();
}
