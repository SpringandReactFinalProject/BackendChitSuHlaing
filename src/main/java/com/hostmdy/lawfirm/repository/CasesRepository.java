package com.hostmdy.lawfirm.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Cases;

public interface CasesRepository extends CrudRepository<Cases, Long> {

}
