package com.blair.eventsBelt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.eventsBelt.models.Event;
import com.blair.eventsBelt.models.User;
import com.blair.eventsBelt.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	public List<Event> findAllEvents() {
		return eRepo.findAll();
	}
	
	public Event findEventById(Long id) {
		return eRepo.findById(id).orElse(null);
	}
	
	public void createEvent(Event event) {
		eRepo.save(event);
	}
	
	public void deleteEvent(Long id) {
		eRepo.deleteById(id);
	}
	
	public void editEvent(Long id, Event event) {
		eRepo.save(event);
	}
	
	public void addUsertoEvent(User user, Event event) {
		List<User> users = event.getAttendees();
		users.add(user);
		eRepo.save(event);
	}
	
	public void removeUserfromEvent(User user, Event event) {
		List<User> users = event.getAttendees();
		users.remove(user);
		eRepo.save(event);
	}
}
