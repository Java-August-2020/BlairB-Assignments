package com.blair.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blair.languages.models.Language;
import com.blair.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.getAllLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String languageDetails(@PathVariable("id") Long id) {
		
		return "languageDetails.jsp";
	}
	//How do I get an html form to have a method of put or delete so I can route the request to below?
//	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	@PostMapping("/languages/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String editLanguagePage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.getOneLanguage(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "editLanguage.jsp";
		} else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/languages/{id}/edit")
	public String editLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "editLanguage.jsp";
		} else {
			languageService.updateLanguage(id, language);
			return "redirect:/languages";
		}
	}
	
	
}
