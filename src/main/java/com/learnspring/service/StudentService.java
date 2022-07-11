package com.learnspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnspring.ini.Student;
import com.learnspring.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public List<Student> getAll()
	{
		return repository.findAll();
	}
	public void addStudent(Student student) {
		 repository.save(student);
	}
	public void deleteStudent(Student student)
	{
		repository.delete(student);
	}
}
