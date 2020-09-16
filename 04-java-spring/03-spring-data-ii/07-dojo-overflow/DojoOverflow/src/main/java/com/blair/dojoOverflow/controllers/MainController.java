package com.blair.dojoOverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blair.dojoOverflow.models.Answer;
import com.blair.dojoOverflow.models.Question;
import com.blair.dojoOverflow.services.AnswerService;
import com.blair.dojoOverflow.services.QuestionService;
import com.blair.dojoOverflow.services.TagService;

@Controller
public class MainController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private TagService tService;
	
	@RequestMapping("/questions")
	public String getQuestions(Model model) {
		model.addAttribute("questions", qService.getAllQuestions());
		return "questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion() {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags) {
		Question newQuestion = new Question(question);
		qService.createQuestion(newQuestion, tags);
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions/{id}")
	public String questionDetail(@PathVariable("id") Long id, Model model) {
		Question question = qService.getQuestionById(id);
		for (Answer answer: question.getAnswers()) {
			System.out.println(answer.getAnswer());
		}
		if (question != null) {
			model.addAttribute("question", question);
			return "questionDetail.jsp";
		} else {
			return "redirect:/questions";
		}
	}
	
	@PostMapping("/questions/{id}")
	public String createAnswer(@PathVariable("id") Long id, @RequestParam("answer") String answer) {
		Question question = qService.getQuestionById(id);
		Answer newAnswer = new Answer(answer, question);
		qService.createAnswer(question, newAnswer);
		return "redirect:/questions/{id}";
	}
}
