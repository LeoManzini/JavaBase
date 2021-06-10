package br.com.leomanzini.bitwise;

import java.util.Scanner;

public class OperationsBitwise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mask = 0b100000;
		int n = sc.nextInt();
		
		if((n & mask) != 0) {
			System.out.println("6th bit is true (1)!");
		} else {
			System.out.println("6th bit is false (0)!");
		}
				
		sc.close();
	}
}
