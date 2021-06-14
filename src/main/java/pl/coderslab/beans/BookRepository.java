package pl.coderslab.beans;

import java.util.List;

import pl.coderslab.model.Book;

public interface BookRepository {

	void create(Book book);
	
	Book read(Long id);
	
	void update(Book book);
	
	void delete(Long id);
	
	List<Book> listAll();
}
