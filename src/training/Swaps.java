package training;


public class Swaps {

	static int minimumSwaps(int[] arr) {
		int swap = 0;
		boolean[] visited = new boolean[arr.length];
		
		for (int i=0;i<arr.length;i++) {
			int j=i, cycle=0;
			while(!visited[j]) {
				visited[j] = true;
				j=arr[j]-1;
				cycle++;
			}
			if(cycle!=0) swap+=cycle-1;
		}
		
		return swap;
	}
	
	public static void main(String[] arg) {
		int[] a = {2,4,5,1,3};
		int res = minimumSwaps(a);
		System.out.println(res);
	}
}
