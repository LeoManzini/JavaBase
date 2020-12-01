package challenges;

public class RecursiveFatorial {
    int calculatefatorial(int fact)
    {
        if(fact == 0)
        {
            return 1;
        }
        return fact * calculatefatorial(fact - 1);
    }
}
