package itexico.training;

import java.util.HashMap;
import java.util.Map;

public class RepetirCadenas {
	static long repeatedString (String s, long n) {
		final long quotient = n/s.length();
		final long remainder = n%s.length();
		
		long aCount = 0;
		
		if ((s.length() == 1) && (s.charAt(0)=='a')) return n;
		
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a') aCount++;
		}
		
		aCount  = aCount * quotient;
		for (int i=0;i<remainder;i++) {
			if(s.charAt(i)=='a') aCount++;
		}
		
		return aCount;
	}
	
	public static int getUniqueCharacterSubstring(String input) {
		Map<Character,Integer> visited =  new HashMap<Character,Integer>();
		String output = "";
		
		for(int start=0,end=0;end < input.length();end++) {
			char currChar = input.charAt(end);
			
			if(visited.containsKey(currChar)) {
				start = Math.max(visited.get(currChar) + 1, start);
			}
			
			if (output.length() < end-start+1) {
				output = input.substring(start,end+1);
			}
			
			visited.put(currChar,  end);
		}
		
		return output.length();
	}
	
	public static void main(String[] arg) {
		String s = "aba";
		long n = repeatedString(s,10);
		System.out.println(n);
		
		System.out.println(getUniqueCharacterSubstring("abcabcbb"));
	}

}
