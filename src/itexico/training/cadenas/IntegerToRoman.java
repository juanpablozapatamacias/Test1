package itexico.training.cadenas;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	
	public static String convert(int num) {
		if(num == 0) return "";
		
		String[] thousands = {"","M","MM","MMM"};
		String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		
		return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert(1996));
	}

}
