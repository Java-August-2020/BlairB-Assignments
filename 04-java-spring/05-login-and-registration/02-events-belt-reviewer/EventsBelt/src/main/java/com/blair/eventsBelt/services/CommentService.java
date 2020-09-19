package com.blair.eventsBelt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.eventsBelt.models.Comment;
import com.blair.eventsBelt.models.Event;
import com.blair.eventsBelt.models.User;
import com.blair.eventsBelt.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cRepo;
	
	public List<Comment> findAllComments() {
		return cRepo.findAll();
	}
	
	public void createComment(Comment comment) {
		cRepo.save(comment);
	}
}
