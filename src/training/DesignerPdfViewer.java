package training;

public class DesignerPdfViewer {
	
	static int viewer(int[] h, String word) {
		char c[] = word.toCharArray();
		int n = c.length;
		int max = 0;
		
		for(int i=0;i<n;i++) {
			int k = (int)c[i] - 97;
			
			if(max < h[k]) max = h[k];
		} 
		
		int res = max * n;
		return res;
	}

	public static void main(String[] argv) {
		int a[] = {1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
		String s = "abc";
		System.out.println(viewer(a,s));
	}
}

