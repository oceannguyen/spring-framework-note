package com.ocean.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyMVCController {

	@RequestMapping(value = "welcomeController.htm", method = RequestMethod.GET)
	public ModelAndView welcome() {

		String welcomeMsg = "Welcome to the wonderful world of Books";

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("message", welcomeMsg);

		return modelAndView;
	}
}
