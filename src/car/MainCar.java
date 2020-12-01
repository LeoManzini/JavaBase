package car;

class MainCar 
{
    public static void main(String args[])
    {
        Car myCar = new Car();
        myCar.color = "Green";
        myCar.model = "Gol";
        myCar.currentSpeed = 0;
        myCar.maxSpeed = 180;

        // Turn the car on
        myCar.turnOn();

        // Acelerate the car
        myCar.speedUp(20);
        System.out.println(myCar.currentSpeed);
    }   
}
