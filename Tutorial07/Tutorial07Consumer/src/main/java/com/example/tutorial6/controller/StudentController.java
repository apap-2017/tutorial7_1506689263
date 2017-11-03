package com.example.tutorial6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tutorial6.model.CourseModel;
import com.example.tutorial6.model.StudentModel;
import com.example.tutorial6.service.CourseService;
import com.example.tutorial6.service.StudentService;

@Controller
public class StudentController {
	@Autowired
    StudentService studentDAO;
	
	@Autowired
	CourseService courseDAO;
	
	String page_title = "";


    @RequestMapping("/")
    public String index(Model model)
    {
    	model.addAttribute("page_title", "Index");
        return "index";
    }

    @RequestMapping("/student/add")
    public String add(Model model)
    {
    	model.addAttribute("page_title", "Add Student");
        return "form-add";
    }


    @RequestMapping(value = "/student/add/submit", method = RequestMethod.GET)
    public String addSubmit(
            @RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gpa", required = false) double gpa,
            Model model)
    {
        StudentModel student = new StudentModel (npm, name, gpa, null);
        studentDAO.addStudent(student);
        model.addAttribute("page_title", "Success Add");
        return "success-add";
    }


    @RequestMapping("/student/view")
    public String view(Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);

        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("page_title", "View Student by NPM");
            return "view";
        } else {
            model.addAttribute("npm", npm);
            model.addAttribute("page_title", "Student not found");
            
            return "not-found";
        }
    }


    @RequestMapping("/student/view/{npm}")
    public String viewPath(Model model,
            @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);

        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("page_title", "View Student by NPM");
            return "view";
        } else {
            model.addAttribute("npm", npm);
            model.addAttribute("page_title", "Student not found");
            return "not-found";
        }
    }


    @RequestMapping("/student/viewall")
    public String view(Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("page_title", "View All Students");
        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete(Model model, @PathVariable(value = "npm") String npm)
    {
    	StudentModel student = studentDAO.selectStudent(npm);
    	if (student != null) {
    		studentDAO.deleteStudent(npm);
    		model.addAttribute("page_title", "Delete");
            return "delete"; 
        } else {
        	model.addAttribute ("npm", npm);
        	model.addAttribute("page_title", "Student not found");
            return "not-found";
        }    
    }
    
    @RequestMapping("/student/update/{npm}")
    public String update(Model model, @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);

        if (student != null) {
        	model.addAttribute("student", student);
        	model.addAttribute("page_title", "Update Student");
            return "form-update";
        	
        } else {
        	model.addAttribute("npm", npm);
        	model.addAttribute("page_title", "Student not found");
            return "not-found";
        }
    }
    
    @RequestMapping(value = "/student/update/submit", method = RequestMethod.POST)
    public String updateSubmit(StudentModel student, Model model)
    {
    	studentDAO.updateStudent(student);
    	model.addAttribute("page_title", "Update Student Success");
        return "success-update";
    }
    
    @RequestMapping("/course/view/{id_course}")
    public String viewCourses (Model model,
            @PathVariable(value = "id_course") String id_course)
    {
        CourseModel course = courseDAO.selectCourse(id_course);
        if (course != null) {
            model.addAttribute ("course", course);
            model.addAttribute("page_title", "View Course by ID");
            return "viewcourses";
        } else {
            model.addAttribute ("id_course", id_course);
            model.addAttribute("page_title", "ID Course Not Found");
            return "not-found-course";
        }
    }
    
    @RequestMapping("/course/viewall")
    public String viewAllCourses(Model model)
    {
        List<CourseModel> course = courseDAO.selectAllCourses();
        model.addAttribute("course", course);
        model.addAttribute("page_title", "View All Courses");
        return "viewall_course";
    }
}
