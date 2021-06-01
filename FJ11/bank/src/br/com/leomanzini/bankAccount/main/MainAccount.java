package br.com.leomanzini.bankAccount.main;

import br.com.leomanzini.bankAccount.Account;
import br.com.leomanzini.bankAccount.CurrentAccount;
import br.com.leomanzini.bankAccount.Date;

public class MainAccount 
{
    public static void main(String args[])
    {
    	CurrentAccount mineAccount = new CurrentAccount(1000.00);
        
        mineAccount.setHolder("Leonardo");
        mineAccount.setOpeningDate(new Date(5, 12, 2020));

        mineAccount.deposit(100);

        
        System.out.println(mineAccount.toString());
        mineAccount.changeType();
        System.out.println(mineAccount.toString());
        System.out.println("Total of open accounts: " + Account.getNumberOfAccounts());
    }
}