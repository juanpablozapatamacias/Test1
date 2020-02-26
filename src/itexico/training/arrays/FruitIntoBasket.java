package itexico.training.arrays;

import java.util.HashMap;

public class FruitIntoBasket {
	
	public static int totalFruit(int[] tree) {
		if(tree == null || tree.length ==0 ) return 0;
		
		int max = 1;
		int min;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int i=0,j=0;
		
		while (j < tree.length) {
			if(map.size() <= 2) map.put(tree[j], j++);
			
			if(map.size() > 2) {
				min = tree.length-1;
				for(int value : map.values()) {
					min = Math.min(min, value);
				}	
				i = min +1;
				map.remove(tree[min]);
			} 
			
			max = Math.max(max, j-i);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,3,3,1,2,1,1,2,3,3,4};
		
		System.out.println(totalFruit(A));
	}

}
