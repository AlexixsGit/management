package com.accenture.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.management.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
