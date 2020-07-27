package training.cadenas;

import java.util.Arrays;

public class StringCompressV2 {
	
	public static int compress(char[] ch) {
		int l=0,r=0, times=1;
		
		while(r < ch.length) {
			if(r+1 != ch.length && ch[r] == ch[r+1]) {
				r++;
				times++;
			}
			else {
				ch[l++] = ch[r];
				//l++;
				if(times !=1) {
					String temp = times + "";
					for(char c : temp.toCharArray()) {
						ch[l] = c;
						l++;
					}
				}
				r++;
				times=1;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'a','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(c));
		System.out.println(Arrays.toString(c));
	}

}
