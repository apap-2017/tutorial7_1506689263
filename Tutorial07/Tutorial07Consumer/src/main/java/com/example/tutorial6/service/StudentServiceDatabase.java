package com.example.tutorial6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorial6.dao.StudentMapper;
import com.example.tutorial6.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public StudentModel selectStudent(String npm){
		log.info("select student with npm {}", npm);
		return studentMapper.selectStudent(npm);
	}
	
	@Override
	public List<StudentModel> selectAllStudents(){
		log.info("select all students");
		return studentMapper.selectAllStudents();
	}
	
	@Override
	public void addStudent(StudentModel student){
		studentMapper.addStudent(student);
	}
	
	@Override
	public void deleteStudent(String npm){
		studentMapper.deleteStudent(npm);
		log.info("student " + npm + " deleted");
	}
	
	
	public void updateStudent(StudentModel student){
		studentMapper.updateStudent(student);
		log.info("student " + student.getNpm() + " updated");
	}
	
	@Override
	public void addCourse(String npm, String idCourse){
		
	}
}
