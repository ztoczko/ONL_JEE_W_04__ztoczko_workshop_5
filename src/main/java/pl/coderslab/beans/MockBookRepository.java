package pl.coderslab.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Book;

@Component
public class MockBookRepository implements BookRepository {

    private Map<Long, Book> books;

    public MockBookRepository() {

        books = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            books.put(Long.valueOf(i), new Book(Long.valueOf(i), "ISBN" + i, "title" + i, "author" + i, "publisher" + i, "type" + i));
        }
    }

    public void create(Book book) {

        System.out.println(book);
        books.put(book.getId(), book);
    }

    public Book read(Long id) {

        return books.get(id);
    }

    public void update(Book book) {

        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    public void delete(Long id) {

        books.remove(id);
    }

    public List<Book> listAll() {

        return new ArrayList(books.values());
    }
}
