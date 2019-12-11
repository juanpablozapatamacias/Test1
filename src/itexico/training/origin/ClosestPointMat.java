package itexico.training.origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPointMat {
	
	public static int[][] kClosestPointsLinear(int[][] points, int k){
		int[][] r = new int[k][];
		Comparator<int[]> cp = new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				int x = (a[0]*a[0]) + (a[1]*a[1]);
				int y = (b[0]*b[0]) + (b[1]*b[1]);
				return x<y ? -1 : ((x==y) ? 0:1);
			}
		};
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(cp);
		
		for(int i=0;i<points.length;i++) {
			pq.add(points[i]);
		}
		
		for (int i=0;i<k;i++) {
			r[i] = pq.remove();
		}
		
		return r;
	}
	
	public static int[][] kClosest(int[][] points, int k){
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>
			((a,b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
		
		for (int[] point : points) {
			maxHeap.add(point);
			
			if(maxHeap.size() > k) maxHeap.remove();
		}
		
		int[][] result = new int[k][2];
		while(k-- > 0) result[k] = maxHeap.remove();
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] points = {{2,2},{-1,0},{3,2},{5,6}};
		
		int[][] res = kClosestPointsLinear(points,2);
		int[][] res2 = kClosest(points,2);
		
	}

}
