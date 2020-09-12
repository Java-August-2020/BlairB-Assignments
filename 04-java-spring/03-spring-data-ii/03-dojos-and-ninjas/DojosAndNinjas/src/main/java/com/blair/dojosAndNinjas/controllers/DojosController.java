package com.blair.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blair.dojosAndNinjas.models.Dojo;
import com.blair.dojosAndNinjas.models.Ninja;
import com.blair.dojosAndNinjas.services.DojoService;
import com.blair.dojosAndNinjas.services.NinjaService;

@Controller
public class DojosController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping("/dojos/new")
	public String newDojo() {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String postDojo(@RequestParam("name") String name) {
		Dojo dojo = new Dojo(name);
		dojoService.createDojo(dojo);
		return "newDojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String postNinja(@ModelAttribute("ninja") Ninja ninja) {
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoDetail(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.getOneDojo(id);
		if (id != null) {
			model.addAttribute("dojo", dojo);
			return "dojoDetail.jsp";
		} else {
			return "redirect:/dojos/new";
		}
	}
}
