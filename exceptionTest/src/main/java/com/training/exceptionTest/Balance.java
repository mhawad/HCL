package com.training.exceptionTest;

public class Balance {
	
	static int flag = 0;

	private int balance;
//	private int withdrawal = 0;
//	private int currentBalance = balance - withdrawal;
	
	
    public Balance() {
    	this.balance = 600; 
    }
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	
	public void checkingBalance(int withdrawal) {
		
//	    
	    
	    try {
	    	this.balance = this.balance - withdrawal;
	    	
			if (withdrawal > balance) {
				throw new InSufficentBalanceException();
		}
	    }

		catch (InSufficentBalanceException e) {
			flag = 1;
			System.out.println("Exception : " + e);
		}
		if (flag == 0)
			System.out.println("Everything is fine");
	}
	
	}

//	public void setWithdrawal(int withdrawal) {
//		this.withdrawal = withdrawal;
//	}
//	
//	public int getWithdrawal() {
//		return this.withdrawal;
//	}
//
//	public void setCurrentBalance(int currentBalance) {
//		this.currentBalance = currentBalance;
//	}
//
//	public int getCurrentBalance() {
//		return this.currentBalance;
//	}
