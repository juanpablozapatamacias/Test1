package training.dfs;

import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveInvalidParenthesis {
	
    public static List<String> remove(String s) {
    	List<String> res = new ArrayList<>();
    	dfs(s,0,0,res,new char[] {'(',')'});
    	return res;
	}

	private static void dfs(String s, int left, int right, List<String> res, char[] pars) {
		// TODO Auto-generated method stub
		int stack =0;
		int n = s.length();
		
		for(;right<n;right++) {
			char c = s.charAt(right);
			if(c == pars[0]) stack++;
			else if(c == pars[1]) stack--;
			
			if (stack < 0) break;
		}
		
		if(stack < 0) {
			for(; left<=right;left++) {
				char c = s.charAt(left);
				if(c != pars[1]) continue;
				if (left >1 && s.charAt(left) == s.charAt(left-1)) continue;
				dfs(s.substring(0,left) + s.substring(left+1),left,right,res,pars);
			}
		}else if (stack > 0) {
			dfs(new StringBuilder(s).reverse().toString(),0,0,res,new char[] {')','('});
		}else {
			res.add(pars[0] == '(' ? s : new StringBuilder(s).reverse().toString());
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()())()";
		System.out.println(remove(s));
	}

}
