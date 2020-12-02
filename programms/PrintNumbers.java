public class PrintNumbers 
{
    public static void main(String args[])
    {
        int i = 0;

        for(i = 150; i <= 300; i++)
        {
            System.out.println("Current number: " + i);
        }

        for(i = 1; i <= 1000; i++)
        {
            int sum = i + i;
            System.out.println(i + " + " + i + " = " + sum);
        }

        for(i = 1; i <= 100; i++)
        {
            int rest = i % 3;
            if(rest == 0)
            {
                System.out.println("The number: " + i + " is a multiple of 3.");
            }
        }

        // Calculates the factorial of a serie of numbers
        long factorial = 1;
        for(i = 1; i <= 10; i++)
        {
            factorial *= i;
            System.out.println("Factorial of " + i + " is " + factorial);
        }

        // Calculates the fibonacci sequence
        int a = 0;
        int b = 1;
        for(i = 0; i < 15; i++) {
            System.out.println(a + " "); // Print the first a = 0
            b += a; // Start with b = 1 + 0
            a = b - a; // Do a = 1 - 0
        }
    
        int x = 20;
        while(x != 1)
        {
            if(x % 2 == 0) {
                x /= 2;
            } else {
                    x = 3 * x + 1;
                }
            System.out.println("The new value for x is: " + x);
        }

        // If you replace the multiplication, this two for print a triangle aligned to the left
        int n = 4; // Total of lines to print  
        for (i = 1; i <= n; i++){   
            for (int j = 1; j <= i; j++){   // Makes j be lower or equal i to print just until the numbers we want
                System.out.print((i*j) + " ");  // Use print to don't break the line
            }   
            System.out.println(" "); // Just to break the lines  
        }   
    }    
}