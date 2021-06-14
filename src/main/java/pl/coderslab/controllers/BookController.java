package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pl.coderslab.beans.BookRepository;
import pl.coderslab.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		
		this.bookRepository = bookRepository;
	}
	
	@PostMapping("")
	public Book create(@RequestBody Book book) {
		
		bookRepository.create(book);
		return book;
	}
	
	@GetMapping("/{id:\\d+}")
	public Book read(@PathVariable Long id) {

//		System.out.println(bookRepository.read(id));
		return bookRepository.read(id);
	}
	
	@PutMapping("")
	public void update(@RequestBody Book book) {
		
		bookRepository.update(book);
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable Long id) {
		
		bookRepository.delete(id);
	}
	
	@GetMapping("")
	public List<Book> listAll() {
		
		return bookRepository.listAll();
	}
	
}
