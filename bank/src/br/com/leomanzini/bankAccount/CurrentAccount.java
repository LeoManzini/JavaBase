package br.com.leomanzini.bankAccount;

public class CurrentAccount extends Account{
	
	private String type = "Current Account";

	public CurrentAccount(double funds) {
		super(funds);
		// TODO Auto-generated constructor stub
	}

	public String getType()
	{
		return this.type;
	}
}
