package com.learnspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnspring.ini.Student;
import com.learnspring.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService s;
	@GetMapping("/getstudent")
	@ResponseBody 
	public Student getStudent()
	{
		return Student.builder().age(25).fname("baba").lname("voo").gender("male").build();
	}
	
	@GetMapping("/")
	public String ListofStudents(ModelMap map)
	{
		List<Student> students= s.getAll();
		map.addAttribute("message",students);
		return "list";
	}
	
	@GetMapping("/addstudent")
	public String addNewstudent(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String gender,@RequestParam int age,ModelMap model) {
		
		Student student=Student.builder().id(id).fname(firstname).lname(lastname).age(age).gender(gender).build();
		s.addStudent(student);
		
		List<Student> students= s.getAll();
		model.addAttribute("message",students);
		return "list";
	}
	@GetMapping("/delete")
	public String deletedata(@RequestParam int id,ModelMap map)
	{
		s.deleteStudent(Student.builder().id(id).fname("bu").age(12).build());
		
		List<Student> students= s.getAll();
		map.addAttribute("message",students);
		return "list";
	}
}
