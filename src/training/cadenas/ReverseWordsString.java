package training.cadenas;

public class ReverseWordsString {
	
	public static String reverse(String s) {
		if(s==null || s.isEmpty()) return s;
		char[] c = s.toCharArray();
		char temp;
		
		int start=0, end=0;
		
		while(start < c.length) {
			while(end < c.length && c[end] !=' ') ++end;
			
			for(int i=start,j=end-1;i<j;++i,--j) {
				temp = c[i];
				c[i] = c[j];
				c[j] = temp;
			}
			
			start = end +1;
			end = start;
		}
		return new String(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I am too busy";
		System.out.println(reverse(s));
	}

}
