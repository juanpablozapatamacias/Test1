package training.dfs;

public class WordSearch {
	
	public static boolean exist(char[][] board, String word) {
		if(board == null || board.length==0 || board[0].length == 0) return false;
		
		int m = board.length;
		int n = board[0].length;
		
		for(int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				if(search(board,word,0,i,j)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean search(char[][] board, String word, int index, int i, int j ) {
		// TODO Auto-generated method stub
		if(index == word.length()) return true;
		
		int m = board.length, n = board[0].length;
		
		if(i<0 || i>=m || j<0 || j>=n || word.charAt(index) != board[i][j]) return false;
		
		char c = board[i][j];
		board[i][j] = '#';
		
		boolean result = search(board,word,index +1,i-1,j) || 
				search(board,word,index+1,i+1,j) || 
				search(board,word,index+1,i,j-1) ||
				search(board,word,index+1,i,j+1);
		
		board[i][j] = c;
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] A = {{'A','B','C','E'},
				      {'S','F','C','S'},
				      {'A','D','E','E'}};
		
		String word = "ABCCED";
		
		System.out.println(exist(A,word));
	}

}
