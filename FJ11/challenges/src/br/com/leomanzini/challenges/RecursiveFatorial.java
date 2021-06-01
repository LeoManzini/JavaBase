package br.com.leomanzini.challenges;

public class RecursiveFatorial {
	
    public int calculatefatorial(int fact)
    {
        if(fact == 0)
        {
            return 1;
        }
        return fact * calculatefatorial(fact - 1);
    }
}
