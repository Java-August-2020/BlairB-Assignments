package com.blair.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.lookify.models.Song;
import com.blair.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	@Autowired
	private LookifyRepository lookifyRepository;
	
	public List<Song> getAllSongs() {
		return lookifyRepository.findAll();
	}
	
	public Song getSongById(Long id) {
		return lookifyRepository.findById(id).orElse(null);
	}
	
	public List<Song> getSongsByArtist(String artist) {
		return lookifyRepository.findByArtistContaining(artist);
	}
	
	public List<Song> getTopTenSongs() {
		List<Song> songs = lookifyRepository.findByOrderByRatingDesc();
		return songs.subList(0, 10);
	}
	
	public void createSong(Song song) {
		lookifyRepository.save(song);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
}
