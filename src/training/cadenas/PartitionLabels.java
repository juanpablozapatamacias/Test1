package training.cadenas;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	public static List<Integer> partition(String S){
		List<Integer> partitionsLenghts = new ArrayList<>();
		
		if(S == null || S.length() == 0) return partitionsLenghts;
		int[] lastIndexes = new int[26];
		
		for(int i=0;i<S.length();i++) {
			lastIndexes[S.charAt(i) - 'a'] = i;
		}
		
		int i = 0;
		while(i <S.length()) {
			int end = lastIndexes[S.charAt(i) - 'a'];
			int j = i;
			
			while(j != end) {
				end = Math.max(end, lastIndexes[S.charAt(j++) - 'a']);
			}
			
			partitionsLenghts.add(j - i + 1);
			i = j+1;
		}
		
		return partitionsLenghts;
	}

	public static void main(String[] args) {
		System.out.println(partition("ababcbacadefegdehijhklij"));
	}

}
