package com.blair.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.relationships.models.Person;
import com.blair.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public void createPerson(Person person) {
		personRepository.save(person);
	}
}