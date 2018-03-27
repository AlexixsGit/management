package com.accenture.management.services;

import org.springframework.transaction.annotation.Transactional;

import com.accenture.management.model.Credit;

@Transactional
public interface CreditService {

	Credit save(Credit credit);

}
