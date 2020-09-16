package com.blair.dojoOverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.dojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	
}
