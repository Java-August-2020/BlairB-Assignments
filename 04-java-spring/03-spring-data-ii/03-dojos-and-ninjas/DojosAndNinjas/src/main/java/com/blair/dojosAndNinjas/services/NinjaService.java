package com.blair.dojosAndNinjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.dojosAndNinjas.models.Ninja;
import com.blair.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public void createNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}

}
