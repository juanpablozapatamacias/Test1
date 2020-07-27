package training.cadenas;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {
	
	public static List<String> combinations(String digits){
		List<String> res = new ArrayList<>();
		if(digits.isEmpty() || digits == null) return res;
		
		String[] maps = {
			"0",
			"1",
			"abc",
			"def",
			"ghi",
			"jkl",
			"mno",
			"pqrs",
			"tuv",
			"wxyz"
		};
		letterCombinations(res,digits,"",0,maps);
		return res;
	}

	private static void letterCombinations(List<String> res, String digits, String current, int index, String[] maps) {
		// TODO Auto-generated method stub
		if(index == digits.length()) {
			res.add(current);
			return;
		}
		
		String letters = maps[digits.charAt(index) - '0'];
		
		for(int i=0;i<letters.length();i++) {
			letterCombinations(res, digits, current+letters.charAt(i), index+1, maps);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinations("23"));
	}

}
