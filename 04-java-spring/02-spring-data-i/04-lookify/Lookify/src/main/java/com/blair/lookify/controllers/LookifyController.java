package com.blair.lookify.controllers;

import java.util.List;

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

import com.blair.lookify.models.Song;
import com.blair.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	private LookifyService lookifyService;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String getDashboard(Model model) {
		List<Song> songs = lookifyService.getAllSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@PostMapping("/dashboard")
	public String searchArtist(@RequestParam("artistSearched") String artistName) {
		return "redirect:/search/" + artistName;
	}
	
	@RequestMapping("/songs/new")
	public String getNew(@Valid @ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String postNewSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "newSong.jsp";
		} else {
			lookifyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String getSongDetail(@PathVariable("id") Long id, Model model) {
		Song song = lookifyService.getSongById(id);
		model.addAttribute("song", song);
		return "songDetail.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String getTopTen(Model model) {
		List<Song> songs = lookifyService.getTopTenSongs();
		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
	
	@RequestMapping("/search/{artistName}")
	public String getSearch(@PathVariable("artistName") String artistName, Model model) {
		List<Song> songs = lookifyService.getSongsByArtist(artistName);
		model.addAttribute("artistName", artistName);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String deleteSong(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
}
