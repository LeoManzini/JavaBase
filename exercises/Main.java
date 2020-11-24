package exercises;

public class Main 
{
    public static void main(String args[])
    {
        // Creating a people
        People person1 = new People();
        People person2 = new People();

        // Setting values
        person1.name = "Giovanna";
        person1.age = 21;

        person2.name = "Mathew";
        person2.age = 20;

        // Make birthday
        person1.birthday();
        person2.birthday();

        // Creating doors
        Door door1 = new Door();
        Door door2 = new Door();
        Door door3 = new Door();

        // Setting values
        door1.color = "Brow";
        door1.xDimension = 0.9;
        door1.yDimension = 2.0;
        door1.zDimension = 0.05;
        door1.close();

        door2.color = "Red";
        door2.xDimension = 0.9;
        door2.yDimension = 2.0;
        door2.zDimension = 0.05;
        door2.open();

        door3.color = "Yellow";
        door3.xDimension = 0.9;
        door3.yDimension = 2.0;
        door3.zDimension = 0.05;
        door3.open();

        // Creating a house and putting the doors
        House myHouse = new House();
        myHouse.door1 = door1;
        myHouse.door2 = door2;
        myHouse.door3 = door3;

        // Checking how many doors are open
        System.out.println(myHouse.manyOpenDoors());
    }    
}
