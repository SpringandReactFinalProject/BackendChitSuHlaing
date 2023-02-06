package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Appointment;

public interface AppointmentService {
		
	Appointment saveOrUpdate(Appointment appointment); 
	
	List<Appointment> findAll();
	
	Optional<Appointment> findById(Long id);
	
	Optional<Appointment> findByName(String name);
	
	void deleteById(Long id);
}
