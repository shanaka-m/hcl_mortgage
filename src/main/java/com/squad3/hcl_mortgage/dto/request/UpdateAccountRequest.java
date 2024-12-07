package com.squad3.hcl_mortgage.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateAccountRequest {
	
	private String acctName;
	private String status;
	private String mortgageType;
	private BigDecimal collateralValue;
	private BigDecimal depositValue;
}
