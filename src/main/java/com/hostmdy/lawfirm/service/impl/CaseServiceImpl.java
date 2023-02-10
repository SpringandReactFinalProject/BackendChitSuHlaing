package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.repository.CasesRepository;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.service.CasesService;

@Service
public class CaseServiceImpl implements CasesService  {

	private final CasesRepository casesRepository;
	private final ContractRepository contractRepository;
	
	
	@Autowired
	public CaseServiceImpl(CasesRepository casesRepository, ContractRepository contractRepository) {
		super();
		this.casesRepository = casesRepository;
		this.contractRepository = contractRepository;
	}

	@Override
	public Cases saveOrUpdate(Cases cases,Long contractId) {
		// TODO Auto-generated method stub
		Contract contract=contractRepository.findById(contractId).get();
		
		//contract - case (one to one)
		contract.setCases(cases);
		cases.setContract(contract);
		
        
       
		return casesRepository.save(cases);
	}

	@Override
	public List<Cases> findAll() {
		// TODO Auto-generated method stub
		return (List<Cases>) casesRepository.findAll();
	}

	@Override
	public Optional<Cases> findById(Long id) {
		// TODO Auto-generated method stub
		return casesRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		casesRepository.deleteById(id);
	}

	

}
