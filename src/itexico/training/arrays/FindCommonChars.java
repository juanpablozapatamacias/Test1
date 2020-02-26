package itexico.training.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.Current;

public class FindCommonChars {

	public static List<String> common(String[] A){
		List<String> commonChars = new ArrayList<>();
		int[] minFreq = new int[26];
		
		Arrays.fill(minFreq, Integer.MAX_VALUE);
		
		for(String current : A) {
			int[] char_freq = new int[26];
			
			for(char c : current.toCharArray()) {
				char_freq[c-'a']++;
			}
			
			for(int i=0;i<26;i++) {
				minFreq[i] = Math.min(minFreq[i],char_freq[i]);
			}
		}
		
		for(int i=0;i<26;i++) {
			while(minFreq[i] > 0) {
				commonChars.add("" + (char)(i+'a'));
				minFreq[i]--;
			}
		}
		
		return commonChars;
	}
	
	public static void main(String[] a) {
		String[] A = {"bella","label","roller"};
		
		System.out.println(common(A));
	}
}
