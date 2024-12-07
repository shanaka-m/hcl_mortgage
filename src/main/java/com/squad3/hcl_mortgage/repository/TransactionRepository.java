package com.squad3.hcl_mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad3.hcl_mortgage.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	Optional<Transaction> findById(int id);
}
