package challenges;

public class MainChallenges 
{
    public static void main(String args[])
    {
        // Testing recursive Fibonacci
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();

        System.out.print("Fibonacci sequence: ");
        for(int i = 0; i <= 10; i++)
        {
            System.out.print(fibonacci.calculateFibonacci(i) + " ");
        }
        System.out.println();
    }    
}
