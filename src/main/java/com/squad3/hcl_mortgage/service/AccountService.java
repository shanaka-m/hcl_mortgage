package com.squad3.hcl_mortgage.service;

import java.util.List;

import com.squad3.hcl_mortgage.dto.request.AccountCreationRequest;
import com.squad3.hcl_mortgage.dto.request.UpdateAccountRequest;
import com.squad3.hcl_mortgage.entity.CustomerAccount;

public interface AccountService {

	List<CustomerAccount> getCustomerAccounts(int custId, String acctType);
	
	CustomerAccount getAccountDetails(String acctId);
	
	CustomerAccount updateAccount(String acctId, UpdateAccountRequest request);
	
	CustomerAccount createAccount(AccountCreationRequest request);
	
}
