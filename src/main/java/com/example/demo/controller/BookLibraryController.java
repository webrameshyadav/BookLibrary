package com.example.demo.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookLibraryController {

	
	@Autowired
	BookService bookService;
	@Autowired
	private MessageSource messageSource;  

	@GetMapping(path="/")
	public  String greeting() {
		return "Welcome to Book Library";
	}
	 
	@GetMapping(path="/book")
    public List<Book>  getBookDetails() {
		return bookService.fetchAllbook();  
    }
	
	@GetMapping(path="/book-internationalized")  
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)  
	{  
	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());  
	}  
	
}
