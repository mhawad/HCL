package com.training.exceptionTest;

public class InSufficentBalanceException extends Exception{

	public InSufficentBalanceException() {
		System.out.println("User defined Exception thrown");
	}

	public String toString() {
		return "Invalid amount given, must be less than or equal to current balance";
	}
}
