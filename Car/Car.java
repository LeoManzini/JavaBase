package Car;

class Engine
{
    int power;
    String type;
}

class Car {
    String color;
    String model;
    double currentSpeed;
    double maxSpeed;
    Engine engine;

    void turnOn()
    {
        System.out.println("The car is on.");
    }

    void speedUp(double speed)
    {
        this.currentSpeed += speed;
    }

    int returnGear() 
    {
        if(this.currentSpeed < 0)
        {
            return -1;
        }
        else if(this.currentSpeed >= 0 && this.currentSpeed < 40)
        {
            return 1;
        }
        else if(this.currentSpeed >= 40 && this.currentSpeed < 80)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }
}
