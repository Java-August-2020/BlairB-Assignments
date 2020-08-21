package com.blair.getFamiliarWithRouting.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{bootcamp}")
	public String dojo(@PathVariable String bootcamp) {
		return "The " + bootcamp + " is awesome!";
	}
	
	@RequestMapping("/{bootcamp}/{isBurbank}")
	public String burbank(@PathVariable String bootcamp, @PathVariable String isBurbank) {
		if (isBurbank.equals("burbank")) {
			return "Burbank Dojo is located in Southern California";
		} else if (isBurbank.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		} else {
			return isBurbank;
		}
	}
}
