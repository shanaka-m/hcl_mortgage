package com.squad3.hcl_mortgage.service.impl;

import java.math.BigDecimal;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.squad3.hcl_mortgage.entity.CustomerAccount;
import com.squad3.hcl_mortgage.entity.Transaction;
import com.squad3.hcl_mortgage.exception.AccountNotFoundException;
import com.squad3.hcl_mortgage.exception.InsufficientBalanceException;
import com.squad3.hcl_mortgage.repository.AccountRepository;
import com.squad3.hcl_mortgage.repository.TransactionRepository;
import com.squad3.hcl_mortgage.service.TransactionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	TransactionRepository transactionRepository;
	AccountRepository accountRepository;
	
	public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public Transaction transferFunds(String drAcctId, String crAcctId, BigDecimal amt, String remarks) {
		CustomerAccount drAcct = validateAndGetAcct(drAcctId);
		CustomerAccount crAcct = validateAndGetAcct(crAcctId);
		
		if (amt.compareTo(drAcct.getBalance()) < 0) {
			throw new InsufficientBalanceException("Insuffiticient balance in account " + drAcctId);
		} 
		
		Transaction transaction = new Transaction();
		transaction.setType("MOT_STL");
		transaction.setCrAcct(crAcctId);


		return null;
		
		
	}

	public CustomerAccount validateAndGetAcct(String acctId) {
		Optional<CustomerAccount> account = accountRepository.findById(acctId);
		if (account.isEmpty()) {
			throw new AccountNotFoundException("Account Id " + acctId + " not found");
		}
		return account.get();
	}
}
