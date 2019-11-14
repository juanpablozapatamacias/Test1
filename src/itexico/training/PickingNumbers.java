package itexico.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingNumbers {
	
	static int pickingNumbers(List<Integer> a) {
		Map<Integer, Integer> freq = new HashMap<Integer,Integer>();
		int maxSet = 0;
		
		for(int i=0;i<a.size();i++) {
			if(freq.containsKey(a.get(i))) {
				freq.put(a.get(i), freq.get(a.get(i)) + 1);
			}
			else {
				freq.put(a.get(i), 1);
			}
		}
		
		for(int j : freq.keySet()) {
			int left = (freq.containsKey(j-1)) ? freq.get(j) + freq.get(j-1) : freq.get(j);
			int right = (freq.containsKey(j+1)) ? freq.get(j) + freq.get(j+1) : freq.get(j);
			
			if(left > maxSet) maxSet = left;
			if(right > maxSet) maxSet = right;
		}
		
		return maxSet;

	}

	public static void main(String[] arg) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		System.out.println(pickingNumbers(list));
	}
}
