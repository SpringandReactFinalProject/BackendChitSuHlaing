package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.InqueryForm;

public interface InqueryFormService {
	InqueryForm saveOrupdate(InqueryForm inqueryForm);
	List<InqueryForm> findAll();
	Optional<InqueryForm> findById(Long id);
//	Optional<InqueryForm> findByuserId(Long userId);
	void deleteById(Long id);
}
