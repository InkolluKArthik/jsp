package com.learnspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.ini.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
