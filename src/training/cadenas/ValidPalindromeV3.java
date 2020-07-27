package training.cadenas;

public class ValidPalindromeV3 {
	
	public static boolean isValid(String s) {
		if(s==null) return false;
		
		int left=0,right=s.length()-1;
		
		while(left <right) {
			if(!Character.isLetterOrDigit(s.charAt(left))) left++;
			else if(!Character.isLetterOrDigit(s.charAt(right))) right--;
			else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			else {
				left++;
				right--;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("A man, a plan, a canal: Panama") ? "VALID":"NO VALID");
	}

}
