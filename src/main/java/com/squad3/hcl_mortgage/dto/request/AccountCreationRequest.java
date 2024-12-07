package com.squad3.hcl_mortgage.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountCreationRequest {
	
	private int custId;
	private String acctNum;
	private String acctName;
	private String mortgageType;
	private BigDecimal mortgageValue;
	private BigDecimal mortgageDeposit;
}
