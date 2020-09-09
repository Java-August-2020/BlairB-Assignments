package com.blair.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blair.books.models.Book;
import com.blair.books.repositories.BookRepository;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}
	
//	public List<Book> allBooks() {
//		return this.bookRepo.findAll();
//	}
	
	public List<Book> allBooks() {
		return books;
	}
	
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
}
