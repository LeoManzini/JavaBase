package exercises;

public class People 
{
    public String name;
    public int age;

    public void birthday()
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
