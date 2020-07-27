package training.bigO.divideconquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysAddParenthesis {

	public static List<Integer> diffWays(String input){
		List<Integer> res = new ArrayList<>();
		
		for(int i = input.length()-1; i>=0; i--) {
			if(input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '*') continue;
			else {
				String left = input.substring(0,i);
				String right = input.substring(i+1);
				
				List<Integer> left_res = diffWays(left);
				List<Integer> right_res = diffWays(right);
				
				for(int left_ele : left_res) {
					for(int right_ele : right_res) {
						int tmp = 0;
						
						switch(input.charAt(i)) {
							case '+':
								tmp = left_ele + right_ele;
								break;
							case '-':
								tmp = left_ele - right_ele;
								break;
							case '*':
								tmp = left_ele * right_ele;
								break;
						}
						
						res.add(tmp);
					}
				}
			}
		}
		
		if(res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2+5*5+3";
		
		System.out.println(diffWays(s));
	}

}
