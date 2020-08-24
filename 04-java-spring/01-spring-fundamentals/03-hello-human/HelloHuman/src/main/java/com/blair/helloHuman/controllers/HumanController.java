package com.blair.helloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false) String nameQuery, Model model) {
		if (nameQuery == null) {
			model.addAttribute("name", "Hello Human!");
		} else {
			model.addAttribute("name", "Hello " + nameQuery + "!");
		}
		return "index.jsp";
	}
}
