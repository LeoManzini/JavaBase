package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class AmountToPay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------- Menu ---------------------");
		System.out.println("Code ----------- Specification ----------- Price");
		System.out.println(" 1 ---------------- Hot Dog ------------- U$ 4.00");
		System.out.println(" 2 ------------- Cheese Salad ----------- U$ 4.00");
		System.out.println(" 3 ------------- Cheese Bacon ----------- U$ 4.00");
		System.out.println(" 4 ---------------- Toast --------------- U$ 4.00");
		System.out.println(" 5 ----------------- Soda --------------- U$ 4.00\n");
		
		System.out.println("What you want and the quantity?");
		int code = sc.nextInt();
		int quantity = sc.nextInt();
		
		double total;
		
		switch(code) {
			case 1:
				total = 4.00 * quantity;
				break;
			case 2:
				total = 4.50 * quantity;
				break;
			case 3:
				total = 5.00 * quantity;
				break;
			case 4:
				total = 2.00 * quantity;
				break;
			case 5:
				total = 1.00 * quantity;
				break;
			default:
				total = 0;
		}
		
		System.out.println("Total: U$" + total);
		
		sc.close();
	}

}
