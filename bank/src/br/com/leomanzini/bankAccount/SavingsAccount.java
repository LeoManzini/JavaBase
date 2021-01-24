package br.com.leomanzini.bankAccount;

public class SavingsAccount extends Account{
	
	private String type = "Savings Account";

	public SavingsAccount(double funds) {
		super(funds, "Savings Account");
	}
	
	@Override
	public String getType()
	{
		return this.type;
	}

	@Override
	public void changeType() 
	{
		this.type = "Current Account";
	}
}
