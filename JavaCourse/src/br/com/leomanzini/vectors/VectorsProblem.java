package br.com.leomanzini.vectors;

import java.util.Scanner;

public class VectorsProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int roomsNumber = sc.nextInt();
		
		Renters[] renters = new Renters[10];
		
		for(int i = 0; i < roomsNumber; i++) {
			System.out.println("\nRent #" + (i + 1));
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.print("Room: ");
			int room = sc.nextInt();
			
			renters[room] = new Renters(name, email, room);
		}
		
		System.out.println("\nBusy rooms: ");
		
		for(int i = 0; i < renters.length; i++) {
			if(renters[i] != null) {
				System.out.println(renters[i].toString());
			}
		}
		
		sc.close();
	}
}
