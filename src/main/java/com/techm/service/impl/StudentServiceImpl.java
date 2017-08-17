package com.techm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.bean.Student;
import com.techm.dao.StudentDAO;
import com.techm.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	public StudentServiceImpl() {
        System.out.println("StudentServiceImpl()");
    }
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.createStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents(String studentName) {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudents(studentName);
	}

}
