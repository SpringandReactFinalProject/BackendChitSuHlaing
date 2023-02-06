package com.hostmdy.lawfirm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

	Optional<Appointment> findByName(String name);
}
