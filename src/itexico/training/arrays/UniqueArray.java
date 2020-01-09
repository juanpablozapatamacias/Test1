package itexico.training.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UniqueArray {
	
	public static void mergeSort(char[] chars) {
		mergeSort(chars,0,chars.length-1);
	}
	
	private static void mergeSort(char[] chars, int low, int right) {
		// TODO Auto-generated method stub
		int mid;
		if(low < right) {
			mid = (low+right) / 2;
			mergeSort(chars,low,mid);
			mergeSort(chars,mid+1,right);
			merge(chars,low,mid,right);
		}
	}

	private static void merge(char[] chars, int low, int mid, int right) {
		// TODO Auto-generated method stub
		Queue<Character> q1 = new LinkedList<Character>();
		Queue<Character> q2 = new LinkedList<Character>();
	
		for(int i=low;i<=mid;i++) q1.add(chars[i]);
		for(int j=mid+1;j<=right;j++) q2.add(chars[j]);

		int i=low;
		 
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(q1.peek() <= q2.peek()) chars[i++] = q1.poll();
			else chars[i++] = q2.poll();
		}
		
		while(!q1.isEmpty()) chars[i++] = q1.poll();
		while(!q2.isEmpty()) chars[i++] = q2.poll();
		
		
	}

	public static boolean isUniqueChar(String str) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] chars = str.toCharArray();
		int cont = 0;
		
		// using sorting to look for duplicated chars
		mergeSort(chars);
		
		for(Character c : chars) {
			if(map.get(c) == null) cont = 1;
			else cont = map.get(c) + 1;
			
			map.put(c, cont);
			
			if(map.get(c) > 1) return false;
		}
		
		/*
		for(int i=0;i<c.length-1;i++) {
			if(c[i] != c[i+1]) continue;
			else return false;
		}*/
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUniqueChar("yolo") ? "String has unique chars" : "String contains repeated chars");
	}

}
