package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Cases;


public interface CasesService {
	
	

	List<Cases> findAll();

	Optional<Cases> findById(Long id);
	
	void deleteById(Long id);

	Cases saveOrUpdate(Cases cases, Long contractId);

}
