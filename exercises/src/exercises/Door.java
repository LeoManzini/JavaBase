package exercises;

public class Door {
    boolean doorOpen;
    public String color;
    public double xDimension;
    public double yDimension;
    public double zDimension;
    
    public void open()
    {
        if(this.isItOpen())
        {
            System.out.println("The door is already open.");
        }
        else
        {
            this.doorOpen = true;
            System.out.println("The door is open.");
        }
    }

    public void close()
    {
        if(this.isItOpen())
        {
            this.doorOpen = false;
            System.out.println("The door is closed.");
        }
        else
        {
            System.out.println("The door is already closed.");
        }
    }

    void paint(String color)
    {
        this.color = color;
        System.out.println("The door is painted " + this.color);
    }

    boolean isItOpen()
    {
        if(this.doorOpen)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
