package training.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Nodo{
	public String word;
	public int depth;
	public Nodo prev;
	
	public Nodo(String word, int depth, Nodo prev) {
		this.word=word;
		this.depth = depth;
		this.prev = prev;
	}
}

public class WordLadderII {

	public static List<List<String>> find(String beginWord, String endWord, List<String> wordList){
		List<List<String>> res = new ArrayList<>();
		
		HashSet<String> unvisited = new HashSet<>();
		unvisited.addAll(wordList);
		
		LinkedList<Nodo> queue = new LinkedList<>();
		Nodo nodo = new Nodo(beginWord, 0, null);
		queue.offer(nodo);
		
		int minLen = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Nodo top = queue.poll();
			
			if(res.size() >0 && top.depth > minLen) return res;
			
			for(int i=0;i<top.word.length();i++) {
				char c = top.word.charAt(i);
				char[] arr = top.word.toCharArray();
				
				for(char j='z';j>='a';j--) {
					if (j == c) continue;
					
					arr[i]=j;
					String temp = new String(arr);
					
					if(temp.equals(endWord)) {
						List<String> aResult = new ArrayList<>();
						aResult.add(endWord);
						Nodo p = top;
						while(p!=null) {
							aResult.add(p.word);
							p = p.prev;
						}
						
						Collections.reverse(aResult);
						res.add(aResult);
						
						if(top.depth <= minLen) minLen = top.depth;
						else return res;
					}
					
					if(unvisited.contains(temp)) {
						Nodo n = new Nodo(temp,top.depth+1,top);
						queue.offer(n);
						unvisited.remove(temp);
					}
				}
			}
		}
		
		return res;
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
		
		System.out.println(find(beginWord,endWord,list));
	}

}
