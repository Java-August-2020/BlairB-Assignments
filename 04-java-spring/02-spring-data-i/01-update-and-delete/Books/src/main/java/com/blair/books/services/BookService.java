package com.blair.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blair.books.models.Book;
import com.blair.books.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}
	
	public List<Book> allBooks() {
		return this.bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public void updateBook(Long id, Book book) {
        if (this.bookRepo.findById(id) != null){
            this.bookRepo.save(book);
        }
    }
	
	public void destroyBook(Long id) {
		if (this.bookRepo.findById(id) != null) {
			this.bookRepo.deleteById(id);
		}
	}
	
}