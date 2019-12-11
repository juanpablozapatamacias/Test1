package itexico.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cadenas {
	
	public static void reverse(String str) {
		if(str==null || str.length() <=1) {
			System.out.println(str);
		}
		else {
			System.out.print(str.charAt(str.length()-1));
			reverse(str.substring(0,str.length()-1));
		}
	}
	
	public static int lastString(String word) {
		String s[] = word.split("\\s+");
		int count = s[s.length-1].length();
		return count;
	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack ==  null || needle ==  null) return 0;
		
		if(needle.length() == 0) return 0;
		
		for (int i=0;i<haystack.length();i++) {
			if(i+needle.length() > haystack.length()) return -1;
			
			int m=i;
			
			for (int j=0;j<needle.length();j++) {
				if (needle.charAt(j) == haystack.charAt(m)) {
					if(j==needle.length() - 1) return i;
					
					m++;
				}
				else break;
			}
		}
		return -1;
	}
	
	public static String countAndSay(int n) {
		if (n==1) return "1";
		if (n==2) return "11";
		
		String str = "11";
		for (int i=3;i<=n;i++) {
			str += "$";
			int len = str.length();
			int cnt=1;
			
			String tmp="";
			
			char[] arr = str.toCharArray();
			
			for(int j=1;j<len;j++) {
				if(arr[j] != arr[j-1]) {
					tmp += cnt + 0;
					tmp += arr[j-1];
					cnt=1;
				}
				else cnt++;
			}
			
			str = tmp;
		}
		
		return str;
	}
	
	public static int compressString(char[] chars) {
		int len = chars.length;
		String tmp = "";
		
		
		for (int i=0;i<len;i++) {
			int count =1;
			while(i < len-1 && chars[i] == chars[i+1]) {
				count++;
				i++;
			}
			tmp += chars[i];
			tmp += count;
		}
		char[] c = tmp.toCharArray();
		System.out.println(tmp);
		
		
		return c.length;
	}
	
	public static int findRotateSteps(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		
		int[][] dp = new int [m+1][n];
		
		for(int i=m-1;i>=0;i--) {
			for(int j=0;j<n;j++) {
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k=0;k<n;k++) {
					if(ring.charAt(k) == key.charAt(i)) {
						int diff = Math.abs(j-k);
						int step= Math.min(diff,n-diff);
						dp[i][j] = Math.min(dp[i][j], step + dp[i+1][k]);
						System.out.print(dp[i][j]);
					}
				}
			}
		}
		return dp[0][0] + m;
	}
	
	public static List<Integer> findSubstring (String s, String[] words){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if(s==null || s.length()==0 || words==null || words.length==0) return res;
		
		//frequency of words
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for (String w : words) {
			if (map.containsKey(w)) map.put(w, map.get(w)+1);
			else map.put(w, 1);
		}
		
		int len = words[0].length();
		
		for(int j=0;j<len;j++) {
			HashMap<String, Integer> currentMap = new HashMap<String,Integer>();
			int start = j;
			int count = 0;
			
			for(int i=j; i<=s.length()-len; i = i + len) {
				String sub = s.substring(i,i+len);
				if (map.containsKey(sub)) {
					//set frequency in the current map
					if(currentMap.containsKey(sub)) currentMap.put(sub,currentMap.get(sub) + 1);
					else currentMap.put(sub, 1);
					
					count++;
					
					while(currentMap.get(sub)>map.get(sub)) {
						String left = s.substring(start,start+len);
						currentMap.put(left, currentMap.get(left)-1);
						
						count--;
						start = start + len;
					}
					
					if(count==words.length) {
						// add to result
						res.add(start);
						
						// shift right and reset currentMap, count and start point
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left)-1);
						
						count--;
						start = start + len;
					}
				}
				else {
					currentMap.clear();
					start = i+len;
					count =0;
				}
			}
		}
		
		return res;
		
	}
	
	public static String convert(String str, int numRows) {
		StringBuilder ret = new StringBuilder();
		int n = str.length();
		int cycleLen = 2 * numRows - 2;
		
		if (numRows == 1) return str;
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j+i<n; j+=cycleLen) {
				ret.append(str.charAt(j+i));
				
				if(i!=0 && i!=numRows-1 && j + cycleLen - i <n)ret.append(str.charAt(j+cycleLen-i));
			}
		}
		
		return ret.toString();

	}
	
	public static void main(String[] args) {
		String s = "halls";
		reverse(s);
		
		int count1=lastString("mundo");
		System.out.println("La ultima cadena tiene " +count1+ " caracteres");

		System.out.println(strStr("halls", "ll"));
		
		System.out.println(countAndSay(5));
		
		System.out.println(compressString(new char[] {'w','w','a','a','a','d','e'}));
		
		System.out.println(findRotateSteps("godding","gd"));
		
		System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
		
		System.out.println(convert("PAYPALISHIRING",3));
	}

}
