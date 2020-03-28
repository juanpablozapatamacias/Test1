package training.cadenas;

public class LengthLastWord {
	
	public static int lenghtLast(String s) {
		int lenght=0;
		
		if(s == null || s.isEmpty()) return lenght;
		
		s = s.trim();
		int n = s.length();
		
		for(int i =n-1;i>=0;--i) {
			if(s.charAt(i) == ' ') break;
			++lenght;
		}
		
		return lenght;
	}

	public static void main(String[] arg) {
		String s = "a";
		
		System.out.println(lenghtLast(s));
	}
}
