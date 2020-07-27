package training;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static List<String> generate(int n){
		List<String> res = new ArrayList<>();
		helper(res,"",n,n);
		return res;
	}
	
	
	private static void helper(List<String> res, String curr, int left, int right) {
		// TODO Auto-generated method stub
		if(left < 0 || left > right) return;
		
		if(left==0 && right ==0) {
			res.add(curr);
			return; 
		}
		
		helper(res, curr + "(", left-1,right);
		helper(res, curr + ")", left, right-1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(3));
	}

}
