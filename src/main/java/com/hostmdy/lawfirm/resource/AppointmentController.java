package com.hostmdy.lawfirm.resource;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.service.AppointmentService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "http://localhost:3000/")
public class AppointmentController {

	private final AppointmentService appointmentService;
	private final MapValidationErrorService mapErrorService;

	@Autowired
	public AppointmentController(AppointmentService appointmentService, MapValidationErrorService mapErrorService) {
		super();
		this.appointmentService = appointmentService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createAppointment(@Valid @RequestBody Appointment appointment,BindingResult result){
		
		ResponseEntity<?> responseErrorObj = mapErrorService.validate(result);
		
		if(responseErrorObj != null)
			return responseErrorObj;
		
		Appointment createAppointment = appointmentService.saveOrUpdate(appointment);
		return new ResponseEntity<Appointment>(createAppointment,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Appointment> findAll() {
		return appointmentService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Appointment> appOptional = appointmentService.findById(id);
		
		if(appOptional.isEmpty())
			return new ResponseEntity<String>("Project with id: "+id+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Appointment>(appOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		Optional<Appointment> appOptional = appointmentService.findByName(name);
		
		if(appOptional.isEmpty()) 
			return new ResponseEntity<String>("Appointment Name: "+name+" is not found.", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Appointment>(appOptional.get(), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		appointmentService.deleteById(id);
		return new ResponseEntity<String>("Delete id="+id, HttpStatus.OK);
	}
	
	
}
