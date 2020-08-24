package com.blair.displayDate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String getDate(Model model) {
		Date date = new java.util.Date();
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String getTime(Model model) {
		model.addAttribute("time", "11:30 PM");
		return "time.jsp";
	}
}
