package com.hostmdy.lawfirm.resource;

import java.security.Principal;
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

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.service.CasesService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;


import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/case")
public class CasesController {

	private final CasesService casesService;
	private final ContractRepository contractRepository;
	private final MapValidationErrorService errorMapService;

	@Autowired
	public CasesController(CasesService casesService, MapValidationErrorService errorMapService,
			ContractRepository contractRepository) {
		super();
		this.casesService = casesService;
		this.contractRepository = contractRepository;
		this.errorMapService = errorMapService;
	}

	//@PostMapping("/user/{userId}/create")
	//@PostMapping("/create")
	@PostMapping("/create/{contractId}")
	public ResponseEntity<?> createCases(@Valid @RequestBody Cases cases,
			BindingResult result,@PathVariable Long contractId) {
		
		System.out.println("Contract Id is"+contractId);

		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);

		if (responseErrorObject != null)
			return responseErrorObject;
		
		//Long contractId=id;

		Cases createCase = casesService.saveOrUpdate(cases,contractId);
		return new ResponseEntity<Cases>(createCase, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public List<Cases>findCases() {
		
		
		List<Cases> casesList= casesService.findAll();
//		if(casesList.isEmpty())
//			return new ResponseEntity<String>("You Have No Any Cases", HttpStatus.NOT_FOUND);
		
		//return new ResponseEntity<Cases>((Cases) casesList, HttpStatus.OK);
		return casesList;

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Cases> casesOptional = casesService.findById(id);

		if (casesOptional.isEmpty())
			return new ResponseEntity<String>("Cases with id =" + id + " not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cases>(casesOptional.get(), HttpStatus.OK);

	}

	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {

		casesService.deleteById(id);
		return new ResponseEntity<String>("Delelte id=" + id + "is deleted", HttpStatus.OK);
	}

}
