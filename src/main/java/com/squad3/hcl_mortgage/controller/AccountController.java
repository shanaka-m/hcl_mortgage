package com.squad3.hcl_mortgage.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.squad3.hcl_mortgage.dto.request.AccountCreationRequest;
import com.squad3.hcl_mortgage.dto.request.UpdateAccountRequest;
import com.squad3.hcl_mortgage.entity.CustomerAccount;
import com.squad3.hcl_mortgage.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/details")
	public ResponseEntity<CustomerAccount> getAccountDetails(@RequestParam(name = "acctId") String acctId) {
		return ResponseEntity.ok(accountService.getAccountDetails(acctId));
	}
	
	
	@PutMapping("/update/{acctId}")
	public ResponseEntity<CustomerAccount> updateAccount(@PathVariable(name = "acctId") String acctId,
														@RequestBody UpdateAccountRequest request) {
		return ResponseEntity.ok(accountService.updateAccount(acctId, request));
	}
	
	@PostMapping("/create/mortgage")
	public ResponseEntity<CustomerAccount> createMortgageAccount(@RequestBody AccountCreationRequest request) {
		return ResponseEntity.ok(accountService.createAccount(request));
	}
}
