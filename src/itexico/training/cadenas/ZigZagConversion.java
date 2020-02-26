package itexico.training.cadenas;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
	
	public static String convert(String s, int rows) {
		Map<Integer, StringBuilder> map = new HashMap<>();
		int pos = 0;
		boolean incr = true;
		StringBuilder res = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			if(pos == rows) incr = false;
			if(pos == 1) incr = true;
			
			if(incr) pos++;
			else pos--;
			
			if(!map.containsKey(pos)) map.put(pos, new StringBuilder());
			
			map.get(pos).append(c);
		}
		
		for(int i : map.keySet()) {
			res.append(map.get(i));
		}
		
		return res.toString();
	}
	
	public static void main(String[] ar) {
		String s = "PAYPALISHIRING";
		
		System.out.println(convert(s,3));
	}

}
