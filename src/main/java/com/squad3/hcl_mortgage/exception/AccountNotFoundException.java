package com.squad3.hcl_mortgage.exception;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4271311606859881213L;

	public AccountNotFoundException(String message) {
        super(message);
    }
}
