package itexico.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BdayCakeCandles {
	static int tallestCandles(int[] arr) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int ele = 0;
		int max = 0;

		for (int i=0;i<arr.length;i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) +1);
		}
		
		Set<Entry<Integer,Integer>> entrySet = hm.entrySet();
		
		for(Entry<Integer,Integer> ent : entrySet) {
			if(ent.getValue() > max) {
				max = ent.getValue();
				ele = ent.getKey();
			}
		}
		
		return max;
	}
	
	public static void main(String[] arg) {
		int[] a = {18,90,90,13,90,75,90,8,90,43};
		System.out.println(tallestCandles(a));
	}

}
