package training.cadenas;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepChars {
	
	public static int longest(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0,right = 0,res = 0;
		
		while(right < s.length()) {
			if(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left++));
			}
			else {
				set.add(s.charAt(right++));
				res = Math.max(res, set.size());
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acdabcdaaaa";
		System.out.println(longest(s));
	}

}
