package training;

import java.util.ArrayList;

public class ArrayDinamico {
	
	public static ArrayList<String> mergeArray(String[] st1, String[] st2){
		ArrayList<String> sentence = new ArrayList<String>();
		
		for(String s : st1) sentence.add(s);
		for(String s : st2) sentence.add(s);
		
		return sentence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"aaa","bbb","ccc"};
		String[] B = {"ddd","eee","aaa"};
		
		System.out.println(mergeArray(A,B));
 	}

}
