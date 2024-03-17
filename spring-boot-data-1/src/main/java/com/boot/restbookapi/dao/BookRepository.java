package com.boot.restbookapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.restbookapi.entities.Book;

public interface BookRepository  extends CrudRepository<Book, Integer>{
	
	public Book  findById(int id);

	
	
	

}
