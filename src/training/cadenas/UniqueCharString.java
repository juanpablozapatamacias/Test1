package training.cadenas;

import java.util.HashMap;

public class UniqueCharString {
	
	public static int firstUniqChar(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char current;
		int min;
		
		for(int i=0;i<s.length();i++) {
			current  = s.charAt(i);
			if(!map.containsKey(current)) 
				map.put(current, i);
			else map.put(current,-1);
		}
		min = Integer.MAX_VALUE;
		for(char c : map.keySet()) {
			if(map.get(c) > -1 && map.get(c) < min)
				min = map.get(c);
		}
		
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "leetcode";
		
		System.out.println(firstUniqChar(s));
	}

}
