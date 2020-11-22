package Bank;

public class MainBankAccount 
{
    public static void main(String args[]) 
    {
        // Creating a bank account
        BankAccount mineAccount = new BankAccount();
        Client client1 = new Client();
        mineAccount.holder = client1;

        // Setting some values to the mine account
        mineAccount.holder.name = "Leonardo";
        mineAccount.holder.lastName = "Manzini";
        mineAccount.holder.cpf = "333.333.333-33";
        mineAccount.number = 123456;
        mineAccount.balance = 15000.0;
        
        // Withdraw money and verify if was successful
        if(mineAccount.withdraw(200))
        {
            System.out.println("Withdraw completed.");
        }
        else
        {
            System.out.println("Insufficient balance.");
        }

        // Deposit money
        mineAccount.deposit(500);
    }    
}
