package br.com.leomanzini.bankAccount;

public interface Authenticable {
	
	public boolean authenticate(String password);
	public boolean passwordIntegrity(String password);
	public boolean validateCPF(String cpf);
	public void changePassword(String cpf, String oldPassword, String newPassword);
	public void printPassword(String cpf);
}
