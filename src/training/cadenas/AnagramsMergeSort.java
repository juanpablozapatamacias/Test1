package training.cadenas;

import java.util.Arrays;

public class AnagramsMergeSort {
	
	public static boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		mergeSort(c1);
		mergeSort(c2);
		
		for(int i=0;i<c1.length;i++) {
			if(c1[i] != c2[i]) return false;
		}
		
		return true;
	}
	
	private static void mergeSort(char[] c) {
		
		int n = c.length;
		int mid = n >> 1;
		int range = n - mid;

		char[] l = new char[mid];
		char[] r = new char[range];
		
		if(n>=2) {
			for (int i=0;i<mid;i++) l[i] = c[i];
			for (int j=mid;j<n;j++) r[j-mid] = c[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) c[k++] = l[i++];
				else c[k++] = r[j++];
			}
			
			while(i<l.length) c[k++] = l[i++];
			while(j<r.length) c[k++] = r[j++];
		}
		
		
		System.out.println(Arrays.toString(c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "paso";
		String s2 = "sopa";
		
		System.out.println(isAnagram(s1,s2) ? "ANAGRAM" : "NOT ANAGRAM");
	}

}
