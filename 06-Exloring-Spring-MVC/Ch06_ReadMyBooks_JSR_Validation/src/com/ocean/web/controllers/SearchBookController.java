package com.ocean.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ocean.dao.model.Book;

@Controller
public class SearchBookController {
	
	@RequestMapping(value = "searchBooks.htm", method = RequestMethod.GET)
	public ModelAndView searchBookByAuthor(@RequestParam("authorName") String authorName) {
		
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", authorName));
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", authorName));
		
		return new ModelAndView("display", "bookList", books);
	}
}
