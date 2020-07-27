package training.cadenas;

import java.util.Arrays;

public class StringCompressV3 {
	
	public static int compress(char[] ch) {
		String out = "";
		int sum =1;
		
		for(int i=0;i<ch.length-1;i++) {
			if(ch[i] == ch[i+1]) {
				sum++;
			}
			else {
				out = out + ch[i] + sum;
				sum=1;
			}
		}
		out = out + ch[ch.length-1] + sum;
		ch = out.toCharArray();
		return out.length();
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'a','a','a','b','c','c'};
		System.out.println(compress(c));
		System.out.println(Arrays.toString(c));
	}

}
