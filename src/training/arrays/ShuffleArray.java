package training.arrays;

import java.util.Arrays;
import java.util.Random;

class Shuffle{
	
	Shuffle(){
		
	}
}

public class ShuffleArray extends Shuffle {
	int[] original = null;
	int[] shuffle = null;
	Random rand =null;
	
	public ShuffleArray(int[] nums) {
		super();
		original = nums;
		shuffle = Arrays.copyOf(nums, nums.length);
		rand = new Random();
	}
	
	public int[] reset() {
		shuffle = Arrays.copyOf(original, original.length);
		return shuffle;
	}

	public int[] shuffle() {
		for (int i=0;i<shuffle.length;i++) {
			int x = rand.nextInt(shuffle.length-i);
			int idx = x+i;
			
			int tmp = shuffle[idx];
			shuffle[idx] = shuffle[i];
			shuffle[i] = tmp;
		}
		
		return shuffle;
	} 
	
	public static void main(String[] a) {
		int[] arr = {1,2,3};
		ShuffleArray s = new ShuffleArray(arr);
		int[] p1 = s.reset();
		System.out.println(Arrays.toString(p1));
		
		int[] p2 = s.shuffle();
		System.out.println(Arrays.toString(p2));
	}
}
