package com.techm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techm.bean.Student;
import com.techm.service.StudentService;

@Controller
public class StudentController {

	private static final Logger logger = Logger.getLogger(StudentController.class);
	
	public StudentController() {
	        System.out.println("StudentController()");
	}
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("createStudent")
	public ModelAndView createStudent(@ModelAttribute Student student){
		logger.info("Creating Student :"+student);
		return new ModelAndView("studentForm");
	}
	
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(@RequestParam int id,@ModelAttribute Student student) {
		logger.info("Updating the Student for the Id "+id);
        student = studentService.getStudent(id);
        logger.info("Student Info:"+student);
        return new ModelAndView("studentForm", "studentObject", student);
	}
	
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") Student student, BindingResult result) {
        if(result.hasErrors()){
        	return new ModelAndView("studentForm");
        }
		
		logger.info("Saving the Student : "+student);        
        if(student.getId() == 0){ 
            studentService.createStudent(student);
        } else {
        	studentService.updateStudent(student);
        }
        return new ModelAndView("redirect:getAllStudents");
    }
	
	@RequestMapping("deleteStudent")
    public ModelAndView deleteStudent(@RequestParam int id) {
        logger.info("Deleting the Employee : "+id);
        studentService.deleteStudent(id);
        return new ModelAndView("redirect:getAllStudents");
    }
	
	@RequestMapping(value = {"getAllStudents", "/"})
    public ModelAndView getAllStudents() {
        logger.info("Getting the all Students.");
        List<Student> studentsList = studentService.getAllStudents();
        return new ModelAndView("studentsList", "studentsList", studentsList);
    }
	
	@RequestMapping("searchStudent")
    public ModelAndView searchStudent(@RequestParam("searchName") String searchName) {  
        logger.info("Searching the Student. Student Name: "+searchName);
        List<Student> studentsList = studentService.getAllStudents(searchName);
        return new ModelAndView("studentsList", "studentsList", studentsList);      
    }

	/*@RequestMapping(value = {"/"})
	public ModelAndView homepage(@ModelAttribute Student student){
		return new ModelAndView("studentForm", "studentObject", student);
	}*/
	
}
