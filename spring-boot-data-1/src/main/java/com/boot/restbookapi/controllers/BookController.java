package com.boot.restbookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.restbookapi.entities.Book;
import com.boot.restbookapi.services.BookServices;

@RestController
public class BookController {
	
	@Autowired
	private BookServices bookservice;
	
	
	//@RequestMapping(value = "/books",method = RequestMethod.GET)
	
	@GetMapping("/books")
	
	
	public  List<Book> getBooks()
	{
		
		/*
		 * Book book = new Book(); book.setId(123456); book.setTitle("spring boot!!!");
		 * book.setAuthor("dixit");
		 */
		//return this.bookservice.getAllBooks();
		
	
		    try {
		        return this.bookservice.getAllBooks();
		    } catch (Exception e) {
		        // Log the exception for debugging purposes
		        //logger.error("Error occurred while fetching books: {}", e.getMessage());
		        // You might want to throw a custom exception or return an error response here
		        throw new RuntimeException("Failed to fetch books. Please try again later.");
		    }
		}
		
		
	@GetMapping("/books/{id}")
	public Book  getBook(@PathVariable("id")int id)
	{
		return bookservice.getBookById(id);
	}
	
	//add the book handler.......................
	@PostMapping("/books")
	public  Book addBook(@RequestBody Book book)
	{
		Book b = this.bookservice.addBook(book);
		
		return b;
		
	}
	//delete book handler	................
	
	@DeleteMapping("/books/{bid}")
	public Book deleteBook(@PathVariable("bid") int bid)
	
	{
		Book book = null;
		this.bookservice.deleteBook(bid);
		
		return book  ;
		
		
		
		
		
	}
	
	//update book handler	................
	
	@PutMapping("/books/{bid}")
	
	public Book updateBook(@RequestBody Book book,@PathVariable("bid") int bid)
	
	{
		this.bookservice.updateBook(book,bid);
		return book;
		
	}
	
	}


