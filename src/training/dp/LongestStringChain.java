package training.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {

	public static int longest(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		List<String> [] wordList = new List[17];
		
		for(String word : words) {
			int len = word.length();
			
			if(wordList[len] == null) wordList[len] = new ArrayList<>();
			
			wordList[len].add(word);
			map.put(word, 1);
		}
		
		int max = 1;
		for(int len=1;len <17;len++) {
			if(wordList[len] == null) continue;
			
			for(String word : wordList[len]) {
				int preLen = len -1;
				
				if(wordList[preLen] == null) continue;
				for(String preWord : wordList[preLen]) {
					if(isPre(preWord, word)) {
						map.put(word, Math.max(map.get(word), map.get(preWord) + 1));
						max = Math.max(max, map.get(word));
					}
				}
				
			}
		}
		
		return max;
		
	}
	
	public static boolean isPre(String a, String b) {
		int p1=0,p2=0;
		boolean found =false;
		while(p1 < a.length() && p2 < b.length()) {
			if(a.charAt(p1) == b.charAt(p2)) {
				p1++;
				p2++;
			}
			else if (found) {
				return false;
			}
			else {
				found =true;
				p2++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] W = {"a","b","ba","bca","bda","bdca"};
		System.out.println(longest(W));
	}

}
