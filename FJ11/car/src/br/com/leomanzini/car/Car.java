package br.com.leomanzini.car;

public class Car {
    public String color;
    public String model;
    public double currentSpeed;
    public double maxSpeed;
    public Engine engine;

    public void turnOn()
    {
        System.out.println("The car is on.");
    }

    public void speedUp(double speed)
    {
        this.currentSpeed += speed;
    }

    public int returnGear() 
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
