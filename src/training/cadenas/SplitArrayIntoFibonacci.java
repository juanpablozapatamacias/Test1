package training.cadenas;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacci {
	
	public static List<Integer> split(String s){
		List<Integer> res = new ArrayList<Integer>();
		helper(s,res,0);
		return res;
	}
	
	private static boolean helper(String s, List<Integer> res, int pos) {
		if(pos == s.length()) return res.size() > 2;
		
		int num =0;
		int n = s.length();
		
		for(int i=pos;i<n;i++) {
			num = num * 10 + (s.charAt(i) - '0');
			
			if(num <0) return false;
			if(res.size() <2 || res.get(res.size()-1) + res.get(res.size()-2) == num) {
				res.add(num);
				if(helper(s,res,i+1)) return true;
				res.remove(res.size()-1);
			}
			
			if(i == pos && s.charAt(i) == '0' ) return false;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "123456789";
		
		System.out.println(split(s));
	}

}
