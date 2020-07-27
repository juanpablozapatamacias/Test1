package training.cadenas;

import java.util.Arrays;

public class StringCompression {
	
	public static int compress(char[] c) {
		if(c==null || c.length ==0) return 0;
		int index = 0;
		int i=0;
		
		while(i < c.length) {
			int j = i;
			while(j<c.length && c[i]==c[j])
				j++;
			
			c[index++] = c[i];
			if(j - i > 1) {
				String count = j-i + "";
				for (char ch : count.toCharArray())
					c[index++] = ch;
			}
			
			i=j;
		}
		
		System.out.println(Arrays.toString(c));
		return index;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbccc";
		System.out.println(compress(s.toCharArray()));
	}

}
