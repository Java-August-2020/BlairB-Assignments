package com.blair.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blair.languages.models.Language;
import com.blair.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> getAllLanguages() {
		return this.languageRepo.findAll();
	}
	
	public Language getOneLanguage(Long id) {
		return this.languageRepo.findById(id).orElse(null);
	}
	
	public Language createLanguage(Language language) {
		return this.languageRepo.save(language);
	}
	
	public void updateLanguage(Long id, Language language) {
		this.languageRepo.save(language);
	}
	
	public void deleteLanguage(Long id) {
		this.languageRepo.deleteById(id);
	}
}
