package itexico.training.origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
}

public class ClosestPoint {
	
	public static Point[] kClosest(Point[] p, int k) {
		
		Comparator<Point> comp = new Comparator<Point>() {
			public int compare(Point a, Point b) {
				int x = (a.x * a.x) + (a.y * a.y);
				int y = (b.x * b.x) + (b.y * b.y);
				return x<y ? -1 : ((x==y) ? 0:1);
			}

		};
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>(comp);
		for (int i=0;i<p.length;i++) {
			pq.add(p[i]);
		}
		
		Point[] r = new Point[k];
		
		for (int i=0;i<k;i++) {
			r[i]= pq.remove();
		}
		
		return r;
	}
	
	public static void main(String[] argv) {
		Point p1 = new Point(2,5);
		Point p2 = new Point(1,1);
		Point p3 = new Point(-2,1);
		Point p4 = new Point(-1,-1);
		Point p5 = new Point(5,-1);
		Point p6 = new Point(0,1);
		
		Point[] p = {p1,p2,p3,p4,p5,p6};
		
		Point[] res = kClosest(p,2);
		
		System.out.println(Arrays.toString(res));
	}

}
