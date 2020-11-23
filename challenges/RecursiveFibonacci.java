package challenges;

public class RecursiveFibonacci 
{
    int a;
    int b = 1;
    int counter;

    int calculateFibonacci()
    {   
        System.out.println(this.a);
        this.b += this.a;
        this.a = this.b - this.a;

        if (this.counter <= 15)
        {
            this.counter++;
        }

        return this.a;
    }
}
