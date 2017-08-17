package com.techm.service;

import java.util.List;

import com.techm.bean.Student;

public interface StudentService {

	public int createStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> getAllStudents();
    public Student getStudent(int id);   
    public List<Student> getAllStudents(String studentName);
}
