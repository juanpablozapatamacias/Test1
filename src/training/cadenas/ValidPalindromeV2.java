package training.cadenas;

public class ValidPalindromeV2 {
	
	public static boolean isValid(String s) {
		if(s == null || s.length() == 0) return true;
		
		String temp = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		
		char[] arr = temp.toCharArray();
		int start =0;
		int end = temp.length()-1;
		
		while(start < end) {
			char left = arr[start];
			char right = arr[end];
			
			if(left - right != 0) return false;
			
			start++;
			end--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("A man, a plan, a canal: Panama") ? "VALID":"NO VALID");
	}

}
