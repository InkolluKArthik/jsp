package com.learnspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learnspring.ini.Book;
@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

}
