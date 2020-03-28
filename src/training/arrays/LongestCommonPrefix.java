package training.arrays;

public class LongestCommonPrefix {
	
	public static String common(String[] strs) {
		String longest = "";
		if(strs == null || strs.length==0) return longest;
		
		int idx = 0;
		
		for(char c : strs[0].toCharArray()) {
			for(int i=1;i<strs.length;i++) {
				if(idx >= strs[i].length() || c != strs[i].charAt(idx)) {
					return longest;
				}
			}
			
			longest += c;
			idx++;
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"flower","flow","flight"};
		
		System.out.println(common(s));
	}

}
