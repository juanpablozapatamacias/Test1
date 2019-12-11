package itexico.training;

import java.util.Scanner;

public class Alien {

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for (int i=0;i<testCases;i++) {
			String input = scanner.next();
			if(input.matches("[_\\.]\\d+[a-zA-Z]*_?"))
				System.out.println("VALID");
			else
				System.out.println("INVALID");
		}
		scanner.close();
	}
}
