package challenges;

public class RecursiveFibonacci 
{
    int calculateFibonacci(int value)
    {   
        if (value < 2) { 
            return value;
            }
        return calculateFibonacci(value - 1) + calculateFibonacci(value - 2);
    }
}
