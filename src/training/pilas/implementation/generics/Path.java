package training.pilas.implementation.generics;

import java.util.LinkedList;

public class Path {

	public String simplifyingPath(String path) throws StackOverflowException, StackUnderFlowException {
		Stack<String> stack = new Stack<>();
		LinkedList<String> res = new LinkedList<String>();
		int start = 0;
		int back = 0;
		String top, s;
		StringBuilder sb = new StringBuilder();
		
		while(path.length()>0 && path.charAt(path.length()-1) == '/') {
			path = path.substring(0,path.length()-1);
		}
		
		for(int i=1;i<path.length();i++) {
			if(path.charAt(i) == '/') {
				stack.push(path.substring(start, i));
				start = i;
			}
			else if(i==path.length()-1) stack.push(path.substring(start));
		}
		
		while(!stack.isEmpty()) {
			top = stack.pop();
			
			if(top.equals("/.") || top.equals("/")) {}
			else if(top.equals("/..")) back++;
			else {
				if(back > 0) back--;
				else res.push(top);
			}
		}
		
		// if empty, return '/'
		if(res.isEmpty()) return "/";
		
		while(!res.isEmpty()) {
			s = res.pop();
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws StackOverflowException, StackUnderFlowException {
		Path p = new Path();
		String path = "/..";
		
		System.out.println(p.simplifyingPath(path));
	}

}
