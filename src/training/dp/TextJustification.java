package training.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TextJustification {
	
	public static List<String> justify(String[] words, int maxWidth){
		List<String> res = new ArrayList<>();
		
		if(words == null || words.length == 0) return res;
		
		int i =0, n=words.length;
		
		while(i<n) {
			int j = i+1;
			int linelenght =words[i].length();
			
			while(j < n && (linelenght + words[j].length() + (j-i-1)) < maxWidth) {
				linelenght += words[j].length();
				j++;
			}
			int diff = maxWidth - linelenght;
			int numWords = j-i;
			
			if(numWords == 1 || j >= n) {
				res.add(leftJustify(words,diff,i,j));
			}
			else {
				res.add(middleJustify(words,diff,i,j));
			}
			
			i=j;
		}
		
		return res;
	}

	private static String middleJustify(String[] words, int diff, int i, int j) {
		int spacesNeeded = j-i-1;
		int spaces = diff / spacesNeeded;
		int extraSpaces = diff % spacesNeeded;
		
		StringBuilder res = new StringBuilder(words[i]);
		for(int k=i+1;k<j;k++) {
			int spacesToApply = spaces + (extraSpaces-- > 0 ? 1:0);
			res.append(String.join("", Collections.nCopies(spacesToApply, " ")) + words[k]);
		}
		
		return res.toString();
	}

	private static String leftJustify(String[] words, int diff, int i, int j) {
		// TODO Auto-generated method stub
		int spacesRight = diff - (j - i - 1);
		
		StringBuilder res = new StringBuilder(words[i]);
		for(int k=i+1;k<j;k++) {
			res.append(" "+words[k]);
		}
		
		res.append(String.join("", Collections.nCopies(spacesRight, " ")));
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"Juan","Pablo","Zapata"};
		int maxWidth = 15;
		System.out.println(justify(A,maxWidth));
	}

}
