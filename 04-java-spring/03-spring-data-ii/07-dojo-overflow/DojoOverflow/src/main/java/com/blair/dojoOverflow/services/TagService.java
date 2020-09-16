package com.blair.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.dojoOverflow.models.Tag;
import com.blair.dojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	public void createTag(Tag tag) {
		tRepo.save(tag);
	}
}
