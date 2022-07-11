package com.learnspring;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnspring.ini.Book;
import com.learnspring.ini.Course;
import com.learnspring.ini.Employee;
import com.learnspring.ini.Library;
import com.learnspring.ini.Movie;
import com.learnspring.ini.Passport;
import com.learnspring.ini.Skill;
import com.learnspring.ini.Student;
import com.learnspring.ini.review;
import com.learnspring.repository.BookRepository;
import com.learnspring.service.LibraryService;
import com.learnspring.service.MovieService;
import com.learnspring.service.StudentService;
@SpringBootApplication
public class FirstSpringProjectApplication implements CommandLineRunner {
	
	@Autowired
	StudentService stu;
	@Autowired
	MovieService mo;
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	BookRepository bookrepo;
	
	@Autowired
	LibraryService lib;
	public static void main(String[] args)  {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
		
		/*System.out.println("Spring started");
		System.out.println("Spring updated");
		System.out.println("hii");
		
		Student s1=new Student();
		s1.setAge(20);
		s1.setFname("ashok");
		s1.setLname("Raj");
		System.out.println("My name is "+s1.getFname()+" "+s1.getLname());
		
		Student s2 =new Student(25,"hello");
		System.out.println("Age is "+s2.getAge());
		
		Student s3=new Student(25,"praneetha");
		
		Student s4= Student.builder().age(30).fname("babu").lname("goa").gender("male").build();
		System.out.println("s4 "+s4.toString());*/
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students= stu.getAll();
		for(Student temp: students)
		{
			System.out.println("-----");
			System.out.println("Id "+temp.getId());
			System.out.println("Fname "+temp.getFname());
		}
	
		
		//one to one//
		/*
		Passport passport =entityManager.find(Passport.class,1);
		System.out.println("name of passport "+passport.getName());
		System.out.println("name of student "+passport.getStudent().getLname());
		
		System.out.println("****Reverse mapping******");
		
		Student student=entityManager.find(Student.class, 2);
		System.out.println("Name of student "+student.getFname());
		System.out.println("Name of passport"+student.getPassport().getName());
		*/
		
		//many to one//
		/*
		review r= entityManager.find(review.class,1);
		System.out.println("message: "+r.getMessage());
		System.out.println("course of this review "+r.getCourse().getName());
		
		
		System.out.println("*****");
		Course course =entityManager.find(Course.class, 2);
		System.out.println("Course name is "+course.getName());
		List<review> rs=course.getReviews();
		for(review t:rs)
		{
			System.out.println("-> "+t.getMessage());
		}
		*/
		
		//many to many
		/*
		Skill skill=entityManager.find(Skill.class, 1);
		System.out.println("Skill name is : "+skill.getName());
		List<Employee> emp=skill.getEmployees();
		for(Employee temp:emp)
		{
			System.out.println("Name is"+temp.getName());
		}
		System.out.println("****reverse***");
		
		Employee empl=entityManager.find(Employee.class, 1);
		System.out.println("Employee name is "+empl.getName());
		List	<Skill> skills =empl.getSkills();
		for(Skill temp: skills)
		{
			System.out.println("SKills are "+temp.getId());
		}
		*/
		//some more operations
		/*Library insertLibrary= Library.builder().id(1).name("Chemistry").bookname("Salts and acids").build();
		lib.addLibrary(insertLibrary);
		Library l1= Library.builder().id(2).name("Maths").bookname("Algebra matrix").build();
		Library l2= Library.builder().id(3).name("Botony").bookname("Pata undi").build();
		Library l3= Library.builder().id(4).name("Zoolgy").bookname("deniko").build();
		
		List<Library> addlibraries=new ArrayList<Library>();
		addlibraries.add(l1);
		addlibraries.add(l2);
		addlibraries.add(l3);
		lib.addManyLibraries(addlibraries);
		//lib.delete(Library.builder().id(3).build());
		//lib.deleteAll();
		//List<Library> liblist1= lib.getAll();
		List<Library> liblist1=lib.sorted("name");
		for(Library temp: liblist1)
		{
			System.out.println("List "+temp.getName());
		}
		System.out.println("*****************");
		Optional<Library> mathsLibrary=lib.getByName("Chemistry");
		if(mathsLibrary.isPresent())
		{
			Library foundLibrary =mathsLibrary.get();
			System.out.println("Book name  "+foundLibrary.getBookname());
					
		}
		else {
			System.out.println("No match found");
		}
		
		long count=lib.getCount();
		System.out.println("Count is " +count);
		*/
		
		//mongo db
		
		//insert
		/*
		Book myBook =Book.builder().id(2).name("Doctor Strange").author("helix").build();
		bookrepo.save(myBook);
		*/
		/*bookrepo.delete(Book.builder().id(2).build());
		List<Book> bs= bookrepo.findAll();
		for(Book temp:bs)
		{
			System.out.println("--------");
			System.out.println("Book name"+temp.getName());
			System.out.println("Author name"+temp.getAuthor());
		}
		Book myBook=Book.builder().id(1).name("Jugle book").author("babai").build();
		bookrepo.save(myBook);
		*/
	}
	
	

}
