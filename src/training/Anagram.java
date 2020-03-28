package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
	
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
		
		HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		
		for(String str : strs) {
			char[] arr =  new char[26];
			
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i) - 'a']++;
			}
			
			String ns = new String(arr);
			
			
			if(map.containsKey(ns)) map.get(ns).add(str);
			else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		
		result.addAll(map.values());
		
		return result;
	}
	
	public static boolean isValidAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for(int i=0;i<c1.length;i++)
			if(c1[i] != c2[i]) return false;
		
		return true;
		
	}
	
	public static void main(String[] argv) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(groupAnagrams(str));
		
		System.out.println(isValidAnagram("listen", "silent"));
		System.out.println(isValidAnagram("triangle", "integral"));
		System.out.println(isValidAnagram("tar", "rac"));
		System.out.println(isValidAnagram("anagram", "nagaram"));
	} 

}
