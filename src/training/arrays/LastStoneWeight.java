package training.arrays;

import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public static int weight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		
		for(int stone : stones) {
			maxHeap.add(-stone);
		}
		
		while(maxHeap.size() > 1) {
			int stoneOne = -maxHeap.remove();
			int stoneTwo = -maxHeap.remove();
			
			if(stoneOne != stoneTwo) maxHeap.add(-(stoneOne - stoneTwo));
		}
		
		return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {2,7,4,1,8,1};
		System.out.println(weight(A));
	}

}
