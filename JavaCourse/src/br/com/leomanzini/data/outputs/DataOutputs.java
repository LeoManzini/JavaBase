package br.com.leomanzini.data.outputs;

public class DataOutputs {
	public static void main(String[] args) {
		
		System.out.print("Hello World!");
		System.out.println(" Good morning!");
		
		int y = 32;
		System.out.println(y);
		
		double x = 10.35784;
		System.out.println(x);
		System.out.printf("%.2f\n", x);
		System.out.println("Result: " + x + " meters");
		System.out.printf("Result: %.2f meters\n", x);
		
		String name = "Giovanna";
		int age = 22;
		double salary = 3300.00;
		System.out.printf("%s is %d years old and receive R$ %.2f\n", name, age, salary);
	}
}
