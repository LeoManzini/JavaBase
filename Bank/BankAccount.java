package Bank;

class Client
{
    String name;
    String lastName;
    String cpf;
}

class BankAccount 
{
    int number;
    double balance;
    Client holder;

    boolean withdraw(double amount) 
    {
        if(this.balance < amount)
        {
            return false;
        }
        else
        {
            this.balance = this.balance - amount;
            return true;
        }
    }

    void deposit(double amount)
    {
        this.balance += amount;
    }

    boolean transferTo(BankAccount destinationAccount, double amount)
    {
        boolean withdrew = this.withdraw(amount);
        if(withdrew)
        {
            destinationAccount.deposit(amount);
            return true;
        }
        else
        {
            return false;
        }
    }
}
