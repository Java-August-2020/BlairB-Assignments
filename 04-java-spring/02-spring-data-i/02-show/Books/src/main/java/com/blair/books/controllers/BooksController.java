package com.blair.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blair.books.models.Book;
import com.blair.books.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
//	@RequestMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/{id}")
//	public String findBookByIndex(Model model, @PathVariable("id") Long id) {
	public String findBookByIndex(Model model, @PathVariable("id") int id) {
//		Book book = bookService.findBook(id);
		Book book = bookService.findBookByIndex(id);
		model.addAttribute("book", book);
		return "/showBook.jsp";
	}
	
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
}
