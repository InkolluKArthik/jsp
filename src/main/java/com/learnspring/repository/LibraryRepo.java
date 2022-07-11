package com.learnspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.ini.Library;

public interface LibraryRepo extends JpaRepository<Library, Long> {

}
