package training;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> dp = new ArrayList<>(triangle.get(triangle.size() - 1));
		for(int i=triangle.size()-2;i>=0;--i) {
			for(int j =0;j<=i;++j) {
				dp.set(j, Math.min(dp.get(j), dp.get(j+1)) + triangle.get(i).get(j));
			}
		}
		return dp.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<>();
		a.add(2);
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		List<Integer> c = new ArrayList<>();
		c.add(6);
		c.add(5);
		c.add(7);
		List<Integer> d = new ArrayList<>();
		d.add(4);
		d.add(1);
		d.add(8);
		d.add(3);
		
		List<List<Integer>> t = new ArrayList<>();
		t.add(a);
		t.add(b);
		t.add(c);
		t.add(d);
		
		System.out.println(minimumTotal(t));
		
	}

}
