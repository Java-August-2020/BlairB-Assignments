package com.blair.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.dojosAndNinjas.models.Dojo;
import com.blair.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo getOneDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
	public void createDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
}
