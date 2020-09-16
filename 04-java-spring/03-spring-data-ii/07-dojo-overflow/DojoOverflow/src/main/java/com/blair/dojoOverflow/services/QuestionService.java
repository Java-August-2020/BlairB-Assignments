package com.blair.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.dojoOverflow.models.Answer;
import com.blair.dojoOverflow.models.Question;
import com.blair.dojoOverflow.models.Tag;
import com.blair.dojoOverflow.repositories.AnswerRepository;
import com.blair.dojoOverflow.repositories.QuestionRepository;
import com.blair.dojoOverflow.repositories.TagRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tRepo;
	@Autowired
	private AnswerRepository aRepo;
	
	public List<Question> getAllQuestions() {
		return qRepo.findAll();
	}
	
	public Question getQuestionById(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	public void createQuestion(Question question, String tags) {
		Question newQuestion = qRepo.save(question);
		List<Tag> allTags = newQuestion.getTags();
		for (String tag: tags.split(",")) {
			if (tRepo.findBySubject(tag.trim()) == null) {
				Tag newTag = new Tag(tag.trim());
				allTags.add(tRepo.save(newTag));
			} else {
				allTags.add(tRepo.findBySubject(tag.trim()));
			}
		}
		qRepo.save(newQuestion);
	}
	
	public void createAnswer(Question question, Answer answer) {
		List<Answer> answers = question.getAnswers();
		answers.add(aRepo.save(answer));
		qRepo.save(question);
	}
}
