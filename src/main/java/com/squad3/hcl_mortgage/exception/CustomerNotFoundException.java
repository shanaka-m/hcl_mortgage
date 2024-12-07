package com.squad3.hcl_mortgage.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -201413320285579659L;

	public CustomerNotFoundException(String message) {
        super(message);
    }
}
