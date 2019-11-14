package itexico.training;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Palindromo {

	public static boolean esPalindromo(String cad) {
		//boolean result;
		
		String temp = cad.replaceAll("[^a-zA-Z0-9]", "");
		char[] c = temp.toLowerCase()
				.replace("á", "a")
				.replace("é", "e")
				.replace("í", "i")
				.replace("ó", "o")
				.replace("ú", "u")
				.toCharArray();
		
	
		System.out.println(Arrays.toString(c));
		int n = c.length;
		
		for(int i=0; i < n-1;i++) {
			if(c[i] != c[(n-1)-i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] ar) {
		if(esPalindromo("Marge, let's \"went.\" I await news telegram.")) System.out.println("Palindromo");
		else System.out.println("No es Palindromo");
		
	}
}
