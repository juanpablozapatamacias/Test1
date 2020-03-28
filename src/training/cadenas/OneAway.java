package training.cadenas;

public class OneAway {
	
	public static boolean method(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length()-s2.length() == 0) return false;
		
		String str1 = s1.length() < s2.length() ? s1 : s2;
		String str2 = s1.length() < s2.length() ? s2 : s2;
		
		assert(str1.length() <= str2.length());
		
		int index1 = 0;
		int index2 = 0;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		boolean foundDiff =false;
		
		while(index1 < s1.length() && index2 < s2.length()) {
			if(chars1[index1] != chars2[index2]) {
				if(foundDiff) return false;
				foundDiff = true;
				if(chars1.length == chars2.length) index1++;
			}
			else index1++;
			
			index2++;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(method("pale","ple"));
		System.out.println(method("pales","pale"));
		System.out.println(method("pale","bale"));
	}

}
