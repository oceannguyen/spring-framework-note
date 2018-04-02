package com.ocean.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocean.beans.Hobby;
import com.ocean.beans.Person;

@Controller
public class AddAttributeController {

	@ModelAttribute("hobbies")
	public List<Hobby> addAttribute() {
		
		List<Hobby> hobbies = new ArrayList<>();
		
		hobbies.add(new Hobby("reading", 1));
		hobbies.add(new Hobby("swimming", 2));
		hobbies.add(new Hobby("dancing", 3));
		hobbies.add(new Hobby("paining", 4));
		
		return hobbies;
	}

	@GetMapping("/showPersonForm.htm")
	public ModelAndView showBookForm(ModelMap map) {

		Person person = new Person();
		map.addAttribute("myPerson", person);

		return new ModelAndView("personForm", map);
	}

	@PostMapping("/addPerson.htm")
	public ModelAndView addBook(@ModelAttribute("myPerson") Person person) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");

		return modelAndView;
	}

}
