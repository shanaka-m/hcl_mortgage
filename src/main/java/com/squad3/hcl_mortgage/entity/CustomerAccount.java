package com.squad3.hcl_mortgage.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "customer_account")
public class CustomerAccount {
	
	@Id
	@Column(name = "acct_number")
	private String acctNum;
	
	@Column(name = "acct_name")
	private String acctName;
	
	@Column(name = "acct_type")
	private String acctType;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "last_tran_dt")
	private LocalDateTime lastTranDt;
	
	@Column(name = "created_dt")
	private LocalDateTime createdDt;
	
	@Column(name = "updated_dt")
	private LocalDateTime updatedDt;
	
	@Column(name = "mortgage_type")
	private String mortgageType;
	
	@Column(name = "collateral_value")
	private BigDecimal mortgageValue;
	
	@Column(name = "deposit_amt")
	private BigDecimal depositAmt;
	
	@ManyToOne
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;
}
