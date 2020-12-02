package exercises;

public class House 
{
    public String color;
    public Door door1;
    public Door door2;
    public Door door3;
    
    void paint(String color)
    {
        this.color = color;
        System.out.println("The house is painted " + this.color);
    }

    public int manyOpenDoors()
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
