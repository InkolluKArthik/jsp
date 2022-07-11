package com.learnspring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.learnspring.ini.Library;
import com.learnspring.repository.LibraryRepo;

@Service
public class LibraryService {

	@Autowired
	LibraryRepo repo;
	public void addLibrary(Library library )
	{
		repo.save(library);
		repo.flush();
	}
	
	public void addManyLibraries(List<Library> libraries )
	{
		repo.saveAll(libraries);
		repo.flush();
	}
	public List<Library> getAll()
	{
		return repo.findAll();
	}
	public Optional<Library> getByName(String name)
	{
		Library sampleLib= Library.builder().name(name).build();
		
		ExampleMatcher em= ExampleMatcher.matching().withMatcher("name",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","bookname");
		
		org.springframework.data.domain.Example<Library> example= org.springframework.data.domain.Example.of(sampleLib,em);
		
		return repo.findOne(example);
	}
	public void deleteAll()
	{
		repo.deleteAll();
	}
	public void delete(Library library)
	{
		repo.delete(library);
	}
	public long getCount()
	{
		return repo.count();
	}
	public List<Library> sorted(String columnName)
	{
		return repo.findAll(Sort.by(Direction.DESC,columnName));
	}
}
