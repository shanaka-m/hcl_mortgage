package com.squad3.hcl_mortgage.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "transaction_history")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tran_type")
	private String type;
	
	@Column(name = "cr_acct")
	private String crAcct;
	
	@Column(name = "dr_acct")
	private String drAcct;
	
	@Column(name = "tran_amt")
	private String tranAmt;
	
	@Column(name = "biz_date")
	private LocalDate bizDate;
	
	@Column(name = "tran_status")
	private String status;
	
	@Column(name = "cr_acct_running_balance")
	private BigDecimal crAcctRunningBalance;
	
	@Column(name = "dr_acct_running_balance")
	private BigDecimal drAcctRunningBalance;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
}
