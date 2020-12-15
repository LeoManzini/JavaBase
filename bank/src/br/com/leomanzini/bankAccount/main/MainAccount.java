package br.com.leomanzini.bankAccount.main;

import br.com.leomanzini.bankAccount.Bank;
import br.com.leomanzini.bankAccount.Date;
import br.com.leomanzini.bankAccount.Employee;

public class MainAccount 
{
    public static void main(String args[])
    {
        Bank mineAccount = new Bank(1000.00);
        
        mineAccount.setHolder("Leonardo");
        mineAccount.setOpeningDate(new Date(5, 12, 2020));

        mineAccount.deposit(100);
        String data = mineAccount.printData();
        
        System.out.println(data);
        System.out.println("Total of open accounts: " + Bank.getNumberOfAccounts());
    }
}