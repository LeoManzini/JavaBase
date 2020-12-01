package exercises;

public class House 
{
    String color;
    Door door1;
    Door door2;
    Door door3;
    
    void paint(String color)
    {
        this.color = color;
        System.out.println("The house is painted " + this.color);
    }

    int manyOpenDoors()
    {
        int total = 0;

        if(this.door1.isItOpen()) 
        {
            total++;
        }
        if(this.door2.isItOpen())
        {
            total++;
        }
        if(this.door3.isItOpen())
        {
            total++;
        }

        return total;
    }
}
