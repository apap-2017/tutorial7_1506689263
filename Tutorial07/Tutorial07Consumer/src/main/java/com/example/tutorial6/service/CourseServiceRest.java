package com.example.tutorial6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.tutorial6.dao.CourseDAO;
import com.example.tutorial6.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class CourseServiceRest implements CourseService{
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public CourseModel selectCourse(String id_course){
		log.info("REST - select course with id {}", id_course);
		return courseDAO.selectCourse(id_course);
	}
	
	@Override
	public List<CourseModel> selectAllCourses(){
		log.info("REST - select all courses");
		return courseDAO.selectAllCourses();
	}
}
