package com.squad3.hcl_mortgage.service;

import java.math.BigDecimal;

import com.squad3.hcl_mortgage.entity.Transaction;

public interface TransactionService {

	Transaction transferFunds(String drAcct, String crAcct, BigDecimal amt, String remarks);
}
