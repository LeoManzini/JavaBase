package exercises;

public class Door {
    boolean doorOpen;
    String color;
    double xDimension;
    double yDimension;
    double zDimension;
    
    void open()
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

    void close()
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
