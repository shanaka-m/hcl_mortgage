package com.squad3.hcl_mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad3.hcl_mortgage.entity.Customer;
import com.squad3.hcl_mortgage.entity.CustomerAccount;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByCustId(int id);
}
