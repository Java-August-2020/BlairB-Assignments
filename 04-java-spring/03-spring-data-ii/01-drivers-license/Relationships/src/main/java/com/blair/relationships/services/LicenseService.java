package com.blair.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blair.relationships.models.License;
import com.blair.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
	public List<License> getAllLicenses() {
		return licenseRepository.findAll();
	}
	
	public License getLicenseById(Long id) {
		return licenseRepository.findById(id).orElse(null);
	}
	
	public void createLicense(License license) {
		System.out.println(license);
		license.setNumber(String.format("00000%d", licenseRepository.count()));
		licenseRepository.save(license);
	}
}
