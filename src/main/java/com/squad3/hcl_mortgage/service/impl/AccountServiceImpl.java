package com.squad3.hcl_mortgage.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.squad3.hcl_mortgage.dto.request.AccountCreationRequest;
import com.squad3.hcl_mortgage.dto.request.UpdateAccountRequest;
import com.squad3.hcl_mortgage.entity.Customer;
import com.squad3.hcl_mortgage.entity.CustomerAccount;
import com.squad3.hcl_mortgage.exception.AccountNotFoundException;
import com.squad3.hcl_mortgage.exception.CustomerNotFoundException;
import com.squad3.hcl_mortgage.exception.InsufficientDepositException;
import com.squad3.hcl_mortgage.repository.AccountRepository;
import com.squad3.hcl_mortgage.repository.CustomerRepository;
import com.squad3.hcl_mortgage.service.AccountService;
import com.squad3.hcl_mortgage.util.Constants;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	private CustomerRepository customerRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
		 this.accountRepository = accountRepository;
		 this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerAccount> getCustomerAccounts(int custId, String acctType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount getAccountDetails(String acctId) {
		Optional<CustomerAccount> optionalAccount =  accountRepository.findByAcctNum(acctId);
		if (optionalAccount.isPresent()) {
			return optionalAccount.get(); 
		} else {
			throw new AccountNotFoundException("Account with ID " + acctId + " not found");
		}
	}

	@Override
	public CustomerAccount updateAccount(String acctId, UpdateAccountRequest request) {
		Optional<CustomerAccount> optionalAccount =  accountRepository.findByAcctNum(acctId);
		CustomerAccount account;
		if (optionalAccount.isPresent()) {
			account = optionalAccount.get(); 
			
			if (request.getMortgageType() != null) {
				account.setMortgageType(request.getMortgageType());
			}
			BigDecimal collateralValue = request.getCollateralValue();
			if (collateralValue != null) {
				BigDecimal deposit = request.getDepositValue();
				
				if (isDepositSufficient(collateralValue, deposit)) {
					account.setDepositAmt(deposit);
				} 
			}
			account.setUpdatedDt(LocalDateTime.now());
			accountRepository.save(account);
			return account;
			
		} else {
			throw new AccountNotFoundException("Account with ID " + acctId + " not found");
		}
	}

	@Override
	public CustomerAccount createAccount(AccountCreationRequest request) {
		int custId = request.getCustId();
		Optional<Customer> customerOpt = customerRepository.findByCustId(custId);
		if (customerOpt.isEmpty()) {
			throw new CustomerNotFoundException("Customer with ID " + custId + " not found");
		}
		
		CustomerAccount newAccount = new CustomerAccount();
		newAccount.setAcctNum(request.getAcctNum());
		newAccount.setAcctName(request.getAcctName());
		newAccount.setAcctType(Constants.ACCT_TYPE_MPRTGAGE);
		newAccount.setStatus(Constants.ACCT_STATUS_ACTIVE);
		newAccount.setMortgageType(request.getMortgageType());
		BigDecimal collateralValue = request.getMortgageValue();
		BigDecimal deposit = request.getMortgageDeposit();
		
		isDepositSufficient(collateralValue, deposit);
		
		newAccount.setCustomer(customerOpt.get());
		newAccount.setMortgageValue(collateralValue);
		newAccount.setDepositAmt(deposit);
		newAccount.setBalance(collateralValue.subtract(deposit).negate());
		newAccount.setCreatedDt(LocalDateTime.now());
		
		return accountRepository.save(newAccount);
		
		
	}

	boolean isDepositSufficient(BigDecimal collateralValue, BigDecimal deposit) {
		if (deposit != null & (deposit.compareTo(collateralValue.multiply(Constants.MIN_DEPOSIT_AMT).divide(BigDecimal.valueOf(100))) >= 0)) {
			return true;
		} else {
			throw new InsufficientDepositException("Deposit should be greated that " + Constants.MIN_DEPOSIT_AMT + " of the mortgage value");
		}
		
	}

}
