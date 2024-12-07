package com.squad3.hcl_mortgage.exception;

public class InsufficientBalanceException extends RuntimeException {
	
	
	private static final long serialVersionUID = -1657703190738893176L;

	public InsufficientBalanceException(String message) {
        super(message);
    }
}
