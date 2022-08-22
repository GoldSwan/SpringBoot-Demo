package com.swan.springbootdev.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView goHome(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> employeeList = new ArrayList<>();

		employeeList.add("alice");
		employeeList.add("sam");
		employeeList.add("tom");

		modelAndView.addObject("employeeList", employeeList);
		modelAndView.setViewName("content/home");

		return modelAndView;
	}
}
