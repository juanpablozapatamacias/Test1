package training.cadenas;

public class Urlify {
	
	public static String replaceSpaces(char[] chars,int len) {
		if(chars == null) return "";
		
		int spaceCount = 0;
		int index = 0;
		
		// first loop, locate last position
		for(int i=0;i<len;i++) {
			if(chars[i]==' ') spaceCount++;
		}
		
		index  = len + spaceCount*2 - 1;
		
		// second loop, replaces spaces from the end
		for (int i=len-1;i>=0;i--) {
			if(chars[i] == ' ') {
				chars[index]='0';
				chars[index-1] = '2';
				chars[index-2] = '%';
				index -=3;
			}
			else {
				chars[index] = chars[i];
				index--;
			}
		}
		return new String(chars).trim();
	}
	
	public static void main(String[] argv) {

		String str = "Juan Pablo Zapata    ";
		int len = str.trim().length();
		
		char[] chars = str.toCharArray();
		System.out.println(replaceSpaces(chars,len));
	}

}
