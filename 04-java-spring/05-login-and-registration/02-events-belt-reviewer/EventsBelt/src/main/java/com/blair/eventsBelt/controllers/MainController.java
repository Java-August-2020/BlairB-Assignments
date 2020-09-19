package com.blair.eventsBelt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blair.eventsBelt.models.Comment;
import com.blair.eventsBelt.models.Event;
import com.blair.eventsBelt.models.User;
import com.blair.eventsBelt.services.CommentService;
import com.blair.eventsBelt.services.EventService;
import com.blair.eventsBelt.services.UserService;
import com.blair.eventsBelt.validator.UserValidator;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;
	@Autowired
	private CommentService cService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping("/")
	public String homePage(@ModelAttribute("user") User user) {
		return "home.jsp";
	}
	
	@PostMapping("/")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "home.jsp";
    	} else {
    		User newUser = uService.registerUser(user);
    		session.setAttribute("user_id", newUser.getId());
    		return "redirect:/events";
    	}
    }
	
	@PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, @ModelAttribute("user") User user, Model model, HttpSession session) {
    	if (uService.authenticateUser(email, password)) {
    		session.setAttribute("user_id", uService.findByEmail(email).getId());
    		return "redirect:/events";
    	} else {
    		model.addAttribute("error", "Failed to log in.");
    		return "home.jsp";
    	}
    }
	
	@RequestMapping("/events")
	public String eventsPage(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		List<Event> events = eService.findAllEvents();
		List<Event> localEvents = new ArrayList<Event>();
		List<Event> otherEvents = new ArrayList<Event>();
		for (Event currentEvent: events) {
			if (currentEvent.getState().equals(user.getState())) {
				localEvents.add(currentEvent);
			} else {
				otherEvents.add(currentEvent);
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("localEvents", localEvents);
		model.addAttribute("otherEvents", otherEvents);
		return "events.jsp";
	}
	
	@PostMapping("/events")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			Long user_id = (Long) session.getAttribute("user_id");
			User user = uService.findUserById(user_id);
			List<Event> events = eService.findAllEvents();
			List<Event> localEvents = new ArrayList<Event>();
			List<Event> otherEvents = new ArrayList<Event>();
			for (Event currentEvent: events) {
				if (currentEvent.getState().equals(user.getState())) {
					localEvents.add(currentEvent);
				} else {
					otherEvents.add(currentEvent);
				}
			}
			model.addAttribute("user", user);
			model.addAttribute("localEvents", localEvents);
			model.addAttribute("otherEvents", otherEvents);
			return "events.jsp";
		} else {
			Long user_id = (Long) session.getAttribute("user_id");
			User user = uService.findUserById(user_id);
			event.setHost(user);
			eService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.DELETE)
	public String deleteEvent(@PathVariable("id") Long id) {
		eService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public String cancelEventAttendance(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		Event currentEvent = eService.findEventById(id);
		eService.removeUserfromEvent(user, currentEvent);
		return "redirect:/events";
	}
	
	@PostMapping(value="/events/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		Event currentEvent = eService.findEventById(id);
		eService.addUsertoEvent(user, currentEvent);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String editEventPage(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		Event currentEvent = eService.findEventById(id);
		if (currentEvent.getHost() == user) {
			model.addAttribute("event", currentEvent);
			model.addAttribute("event_id", id);
			return "editEvent.jsp";
		} else {
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/events/{id}/edit", method=RequestMethod.PUT)
	public String editEvent(@PathVariable("id") Long id, @ModelAttribute("event") Event event, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		event.setHost(user);
		eService.editEvent(id, event);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}")
	public String eventDetail(@PathVariable("id") Long id, Model model) {
		Event event = eService.findEventById(id);
		model.addAttribute("event", event);
		return "eventDetail.jsp";
	}
	
	@PostMapping("/events/{id}/newComment")
	public String addComment(@PathVariable("id") Long id, @RequestParam("comment") String comment, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uService.findUserById(user_id);
		Event event = eService.findEventById(id);
		Comment newComment = new Comment(comment, user, event);
		cService.createComment(newComment);
		return "redirect:/events/" + event.getId();
	}
	
}
