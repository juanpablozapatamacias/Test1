package training.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Beautiful {

	static Map<Integer, int[]> memo;
	
	public static int[] beautifulArray(int n) {
		memo = new HashMap<>();
		return f(n);
	}
	
	private static int[] f(int n) {
		int t=0;
		if(memo.containsKey(n)) return memo.get(n);
		
		int[] ans=new int[n];
		if(n==1) ans[0]=1;
		else {
			for(int x : f((n+1)/2)) ans[t++] = 2*x-1;
			for(int x : f(n/2)) ans[t++] = 2*x;
		}
		memo.put(n, ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(beautifulArray(5)));
	}

}
