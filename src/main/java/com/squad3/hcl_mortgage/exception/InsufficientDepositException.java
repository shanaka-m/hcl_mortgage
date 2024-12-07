package com.squad3.hcl_mortgage.exception;

public class InsufficientDepositException extends RuntimeException {
	
	
	private static final long serialVersionUID = 2040130383813879638L;

	public InsufficientDepositException(String message) {
        super(message);
    }
}
