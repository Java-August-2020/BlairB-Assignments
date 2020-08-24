package com.blair.theCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors, Model model) {
		model.addAttribute("error", errors);
		return "index.jsp";
	}
	
	@RequestMapping(path="/check", method=RequestMethod.POST) 
	public String checkCode(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("success", "success");
		if (code.equals("bushido")) {
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String code(@ModelAttribute("success") String success, RedirectAttributes redirectAttributes) {
		if (success.equals("success")) {
			return "theCode.jsp";
		} else {
			redirectAttributes.addFlashAttribute("errors", "Enter the correct code!");
			return "redirect:/";
		}
		
	}
	
	
}
