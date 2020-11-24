package exercises;

public class People 
{
    String name;
    int age;

    void birthday()
    {
        this.age++;
        if(this.name == "Giovanna")
        {
            System.out.println("Happy " + this.age + " years old my darling!!");
        }
        else
        {
            System.out.println("Happy " + this.age + " years old " + this.name + "!!");
        }
    }
}
