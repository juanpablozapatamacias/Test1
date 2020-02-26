package itexico.training.cadenas;

public class CountAndSay {
	
	public static String count(int n) {
		if(n<=0) return "";
		
		String res = "1";
		int count;
		
		while(n > 1) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<res.length();++i) {
				count =1;
				while(i+1 < res.length() && res.charAt(i) == res.charAt(i+1)) {
					++count;
					++i;
				}
				sb.append(count).append(res.charAt(i));
			}
			res = sb.toString();
			--n;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 111221;
		System.out.println(count(n));
	}

}
