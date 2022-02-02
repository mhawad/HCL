package com.training.exceptionTest;

import java.util.Scanner;

public class Main {

	static int flag = 0;

	public static void main(String args[]) {

		Balance b1 = new Balance();
		Scanner kp = new Scanner(System.in);

		System.out.println("Enter the balance: ");
		b1.setBalance(kp.nextInt());

		kp.nextLine();
		
		b1.checkingBalance(500);
	}
}

//		try {
//
//			if (b1.setWithdrawal() > b1.setCurrentBalance())
//				throw new InSufficentBalanceException();
//		}
//
//		catch (InSufficentBalanceException e) {
//			flag = 1;
//			System.out.println("Exception : " + e);
//		}
//		if (flag == 0)
//			System.out.println("Everything is fine");
//	}


