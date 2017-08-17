package com.techm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techm.bean.Student;
import com.techm.dao.StudentDAO;
import com.techm.util.HibernateUtil;

@Repository
public class StudentDAOImpl implements StudentDAO {

	public StudentDAOImpl() {
        System.out.println("StudentDAOImpl");
    }
	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		return (int) hibernateUtil.create(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setId(id);
		hibernateUtil.delete(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchAll(Student.class);
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(id, Student.class);
	}

	@Override
	public List<Student> getAllStudents(String studentName) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM students WHERE stud_name like '%"+ studentName +"%'";
		List<Object[]> studentObjects=hibernateUtil.fetchAll(query);
		List<Student> students=new ArrayList<Student>();
		
		for(Object[] studentObject: studentObjects){
			Student student=new Student();
			int id= ((Integer)studentObject[0]).intValue();
			String name= (String)studentObject[1];
			Date dob= (Date)studentObject[2];
			String stream= (String)studentObject[3];
			String clg= (String)studentObject[4];
			student.setId(id);
			student.setDob(dob);
			student.setName(name);
			student.setStream(stream);
			student.setClg(clg);
			students.add(student);
		}
		System.out.println(students);
		return students;
	}

}
