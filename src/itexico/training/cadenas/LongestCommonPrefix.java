package itexico.training.cadenas;

public class LongestCommonPrefix {
	
	public static String longest(String[] strs) {
		if(strs == null || strs.length==0) return "";
		
		for(int j=0;j<strs[0].length();++j) {
			for(int i=1;i<strs.length;++i) {
				if(j >= strs[i].length() || 
						strs[i].charAt(j) != strs[0].charAt(j)) {
					return strs[i].substring(0,j);
				}
			}
		}
		
		return strs[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] st = {"flower", "flow", "flight"};
		System.out.println(longest(st));
	}

}
