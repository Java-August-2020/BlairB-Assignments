package com.blair.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blair.relationships.models.License;
import com.blair.relationships.models.Person;
import com.blair.relationships.services.LicenseService;
import com.blair.relationships.services.PersonService;


@Controller
public class RelationshipsController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String postNewPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personService.createPerson(person);
//			relationshipsService.getPerson();
//			return "redirect:/persons/" + id;
			return "newPerson.jsp";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String getPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.getPersonById(id);
		if (person != null) {
			model.addAttribute("person", person);
			return "personDetails.jsp";
		} else {
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String getLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String postLicense(@ModelAttribute("license") License license, Model model) {
		System.out.println("In license POST");
		List<Person> persons = personService.getAllPersons();
		System.out.println(persons);
		model.addAttribute("persons", persons);
		
		licenseService.createLicense(license);
		return "redirect:/persons/new";
	}
	
	
	
}
