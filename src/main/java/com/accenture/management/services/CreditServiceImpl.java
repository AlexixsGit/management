package com.accenture.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.management.model.Credit;
import com.accenture.management.repositories.CreditRepository;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditRepository creditRepository;

	@Override
	public Credit save(Credit credit) {
		return this.creditRepository.save(credit);
	}

}
