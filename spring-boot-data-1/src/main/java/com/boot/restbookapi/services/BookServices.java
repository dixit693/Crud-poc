package com.boot.restbookapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.restbookapi.dao.BookRepository;
import com.boot.restbookapi.entities.Book;

@Component
public class BookServices {
	@Autowired
	private BookRepository bookRepository;
	
// fake service because we are not fetching data from database	.
	/*
	 * private static List<Book> list= new ArrayList<>();
	 * 
	 * static {
	 * 
	 * list.add(new Book(12,"java","dixit"));
	 * 
	 * list.add(new Book(13,"sql","dixit"));
	 * 
	 * list.add(new Book(14,"linux","dixit"));
	 * 
	 * list.add(new Book(15,"redhat","dixit"));
	 * 
	 * list.add(new Book(16,"html","dixit")); }
	 */
	
	public List<Book> getAllBooks() {
		//return list;
	
	List <Book> list = (List<Book>) this.bookRepository.findAll();
	
	return list;
	}
	
	public Book getBookById(int id)
	{
		
		
		  
		Book book = null;
		  
		  //book = list.stream().filter(f->f.getId()==id).findFirst().get();
		 
		 //return book;
		 
		
		return book = this.bookRepository.findById(id);
		
		}
	
	// adding the books  
	public Book  addBook (Book b)
	{
		
		Book result  = this.bookRepository.save(b);
		return result ;
		
	}
	
	// delete the books..............
	
	
	public void deleteBook(int bid)
	{
		/*
		 * List<Book> filteredList = list.stream() .filter(book -> book.getId() != bid)
		 * .collect(Collectors.toList());
		 */
		
		bookRepository.deleteById(bid);
		
	}
	
	// update  the books..............
	
	public void updateBook(Book book, int bookID)
	{
		
		/*
		 * list = list.stream().map(b-> { if (b.getId()==bookID) {
		 * b.setTitle(book.getTitle()); } return b; }).collect(Collectors.toList());
		 */
		
		
		book.setId(bookID);
		
		bookRepository.save(book);
		
	}
}
