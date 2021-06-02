package br.com.leomanzini.exercise.one;

import java.util.Scanner;

public class SellItens {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with first the item code: ");
		@SuppressWarnings("unused")
		int itemOne = sc.nextInt();
		
		System.out.println("Enter with first the item amount: ");
		int itemOneAmount = sc.nextInt();
		
		System.out.println("Enter with first the unity price: ");
		double itemOnePrice = sc.nextDouble();
		
		System.out.println("Enter with second the item code: ");
		@SuppressWarnings("unused")
		int itemTwo = sc.nextInt();
		
		System.out.println("Enter with second the item amount: ");
		int itemTwoAmount = sc.nextInt();
		
		System.out.println("Enter with second the unity price: ");
		double itemTwoPrice = sc.nextDouble();
		
		System.out.printf("Total to pay: R$ %.2f", ((itemOnePrice * itemOneAmount) + (itemTwoPrice * itemTwoAmount)));
		
		sc.close();
	}
}
