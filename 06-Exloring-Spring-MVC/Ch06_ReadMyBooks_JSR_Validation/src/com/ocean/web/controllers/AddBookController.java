package com.ocean.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocean.dao.model.Book;

@Controller
public class AddBookController {

	@ModelAttribute("priceList")
	public List<Integer> addPrices() {

		List<Integer> prices = new ArrayList<>();
		prices.add(300);
		prices.add(350);
		prices.add(400);
		prices.add(500);
		prices.add(550);
		prices.add(600);

		return prices;
	}

	@GetMapping("showBookForm.htm")
	public ModelAndView showBookForm(ModelMap map) {

		Book book = new Book();
		map.addAttribute("book", book);

		return new ModelAndView("bookForm");
	}

	@PostMapping("addBook.htm")
	public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return new ModelAndView("bookForm");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");

		List<Book> books = new ArrayList<>();
		books.add(book);

		modelAndView.addObject("bookList", books);

		return modelAndView;
	}

}
