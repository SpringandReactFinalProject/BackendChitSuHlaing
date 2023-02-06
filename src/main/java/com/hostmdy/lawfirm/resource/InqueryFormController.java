package com.hostmdy.lawfirm.resource;

import java.util.List;
import java.util.Optional;

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

import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.service.InqueryFormService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inquery")
@CrossOrigin(origins = "http://localhost:3000/")
public class InqueryFormController {

	private final InqueryFormService inqueryFormService;
	private final MapValidationErrorService mapErrorService;
	
	public InqueryFormController(InqueryFormService inqueryFormService, MapValidationErrorService mapErrorService) {
		super();
		this.inqueryFormService = inqueryFormService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createInqueryForm(@Valid @RequestBody InqueryForm inqueryForm, BindingResult result) {
		ResponseEntity<?> responseErrorObj = mapErrorService.validate(result);
		
		if(responseErrorObj != null) 
			return responseErrorObj;
		
		InqueryForm createInquery = inqueryFormService.saveOrupdate(inqueryForm);
		return new ResponseEntity<InqueryForm>(createInquery, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<InqueryForm> findAll(){
		return inqueryFormService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<InqueryForm> inqueryOptional = inqueryFormService.findById(id);
		if(inqueryOptional.isEmpty())
			return new ResponseEntity<String>("InqueryForm id:"+id+"is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<InqueryForm>(inqueryOptional.get(), HttpStatus.OK);
	}
	
//	@GetMapping("/userid/{userid}")
//	public ResponseEntity<?> findByUserId(@PathVariable Long userid){
//		Optional<InqueryForm> inOptional = inqueryFormService.findByuserId(userid);
//		if(inOptional.isEmpty())
//			return new ResponseEntity<String>("User Id:"+userid+" is not found",HttpStatus.NOT_FOUND);
//		return new ResponseEntity<InqueryForm>(inOptional.get(),HttpStatus.OK);
//	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleById(@PathVariable Long id){
		inqueryFormService.deleteById(id);
		return new ResponseEntity<String>("Deleted id= "+id, HttpStatus.OK);
	}
}
