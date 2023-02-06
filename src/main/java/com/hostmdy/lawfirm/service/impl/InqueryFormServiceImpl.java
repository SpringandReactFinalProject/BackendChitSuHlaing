package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.repository.InqueryFormRepository;
import com.hostmdy.lawfirm.service.InqueryFormService;
@Service
public class InqueryFormServiceImpl implements InqueryFormService{

	private final InqueryFormRepository inqueryFormRepository;
	
	
	@Autowired
	public InqueryFormServiceImpl(InqueryFormRepository inqueryFormRepository) {
		super();
		this.inqueryFormRepository = inqueryFormRepository;
	}

	@Override
	public InqueryForm saveOrupdate(InqueryForm inqueryForm) {
		
		return inqueryFormRepository.save(inqueryForm);
	}

	@Override
	public List<InqueryForm> findAll() {
		return (List<InqueryForm>) inqueryFormRepository.findAll();
	}

	@Override
	public Optional<InqueryForm> findById(Long id) {
		return inqueryFormRepository.findById(id);
	}

//	@Override
//	public Optional<InqueryForm> findByuserId(Long userId) {
//		return inqueryFormRepository.findByUserId(userId);
//	}

	@Override
	public void deleteById(Long id) {
		inqueryFormRepository.deleteById(id);
		
	}

}
