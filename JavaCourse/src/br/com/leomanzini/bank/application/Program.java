package br.com.leomanzini.bank.application;

import java.util.Locale;
import java.util.Scanner;

import br.com.leomanzini.bank.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account ac = null;
		
		System.out.print("Enter account number: ");
		int accNumber = sc.nextInt();
		
		System.out.print("\nEnter account holder: ");
		String holder = sc.next();
		System.out.println();
		
		System.out.print("Is there an initial deposit? (y/n) ");
		String option = sc.next();
		option.toLowerCase();
		
		if(option.charAt(0) == 'y') {
			System.out.print("\nEnter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			ac = new Account(accNumber, holder, initialDeposit);
		} else {
			ac = new Account(accNumber, holder);
		}
		
		System.out.println("\nInitial data: " + ac);
		
		System.out.print("\nEnter with a deposit value: ");
		double amount = sc.nextDouble();
		ac.deposit(amount);
		
		System.out.println("\nUpdated data: " + ac);
		
		System.out.print("\nEnter with a withdraw value: ");
		amount = sc.nextDouble();
		ac.withdraw(amount);
		
		System.out.println("\nUpdated data: " + ac);
		
		sc.close();
	}

}
