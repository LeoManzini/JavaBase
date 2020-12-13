package br.com.leomanzini.bankAccount;

import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas
{
	public void criaConta(Evento evento)
	{
		BankAccount conta = new BankAccount(1000.0);
		conta.setHolder("Batman");
	}
}