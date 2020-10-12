package training.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if(!wordSet.contains(endWord)) return 0;
		
		Queue<String> q =new LinkedList<>();
		q.offer(beginWord);
		int res = 0;
		
		while(!q.isEmpty()) {
			for(int k = q.size();k>0;k--) {
				String word = q.poll();
				
				if(word.equals(endWord)) return res+1;
				
				for(int i=0;i<word.length();i++) {
					char[] newWord = word.toCharArray();
					for (char ch='a';ch <='z';ch++) {
						newWord[i] = ch;
						String s = new String(newWord);
						if(wordSet.contains(s) && !s.equals(word)) {
							q.offer(s);
							wordSet.remove(s);
						}  
					}
				}
			}
			res++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		List<String> list = new ArrayList<>(); 
		
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		
		System.out.println(ladderLength(beginWord,endWord,list));
	}

}
