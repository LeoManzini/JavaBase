package br.com.leomanzini.bank;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	
	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}
	
	public Account(int number, String holder, double firstDeposit) {
		this.number = number;
		this.holder = holder;
		deposit(firstDeposit);
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount < this.balance) {
			balance -= amount + 5.00;
		} else {
			System.out.println("\nNot have funds.");
		}
	}

	@Override
	public String toString() {
		return "Account " + number + ", Holder: " + holder + ", Balance: $" + String.format("%.2f", balance);
	}
}
