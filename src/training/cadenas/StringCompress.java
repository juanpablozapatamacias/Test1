package training.cadenas;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompress {

	public static String compress(String str) {
		String output = "";
		char[] c = str.toCharArray();
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		for(int i=0;i<c.length;i++) {
			if(i>0 && c[i] != c[i-1]) {
				output = output + c[i-1] + map.get(c[i-1]);
				map.put(c[i-1],0);
			}
			if(map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i]) + 1);
			}
			else {
				map.put(c[i], 1);
			}
		}
		
		for(Character ch : map.keySet()) {
			if(map.get(ch) != 0 ) output = output + ch + map.get(ch);
		}
		
		return output;
	}
	
	public static int compress(char[] chars) {
		if(chars==null || chars.length==0) return 0;
		
		int pos = 0;
		int count = 0;
		int i = 0;
		char cur;
		
		while(i<chars.length) {
			cur = chars[i];
			while(i<chars.length && chars[i] == cur) {
				count++;
				i++;
			}
			
			chars[pos++] = chars[i-1];
			
			if(count > 1) {
				for(char c : (""+count).toCharArray()) chars[pos++] = c;
			}
			count = 0;
		}
		
		return pos;
	}
	
	public static int compress1(char[] chars) {
		int len = chars.length;
		int count = 0;
		String tmp="";
		
		for(int i=0;i<len;i++) {
			count = 1;
			while(i<len-1 && chars[i] == chars[i+1]) {
				count++;
				i++;
			}
			
			tmp+=chars[i];
			tmp+=count;
		}
		
		System.out.println(tmp);
		return tmp.toCharArray().length;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aaaaaaa"));
		System.out.println(compress("aaaaaaa".toCharArray()));
		System.out.println(compress1("aaaaaaa".toCharArray()));
	}

}
