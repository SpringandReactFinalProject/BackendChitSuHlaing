package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.service.ContractServices;

@Service
public class ContractServiceImpl implements ContractServices  {
	
	
	private final ContractRepository contractRepository;
	
	
	
    @Autowired
	public ContractServiceImpl(ContractRepository contractRepository) {
		super();
		this.contractRepository = contractRepository;
	}

	@Override
	public Contract saveOrUpdate(Contract contract) {
		// TODO Auto-generated method stub
		return contractRepository.save(contract);
	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return (List<Contract>) contractRepository.findAll();
	}

	@Override
	public Optional<Contract> findById(Long id) {
		// TODO Auto-generated method stub
		return contractRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		contractRepository.deleteById(id);
		
	}

	@Override
	public Contract updateContract(Contract contract) {
		// TODO Auto-generated method stub
		//get original associated case object of contract
		Long contractId=contract.getId();
		Cases cases=contractRepository.findById(contractId).get().getCases();
		
		if(cases !=null) {
			//contract-case
			contract.setCases(cases);
			cases.setContract(contract);
			
		}				
				
				return contractRepository.save(contract);
		
	}

}
