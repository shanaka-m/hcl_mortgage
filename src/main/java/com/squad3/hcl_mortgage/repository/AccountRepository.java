package com.squad3.hcl_mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad3.hcl_mortgage.entity.CustomerAccount;


public interface AccountRepository extends JpaRepository<CustomerAccount, String> {

	Optional<CustomerAccount> findByAcctNum(String id);
}
