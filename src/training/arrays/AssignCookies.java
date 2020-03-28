package training.arrays;

public class AssignCookies {
	
	public static int findContentChildren(int[] g, int[] s) {
		merge(g);
		merge(s);
		
		int contentChildren = 0;
		
		int i = g.length - 1;
		int j = s.length - 1;
		
		while(i >= 0 && j >= 0) {
			if(s[j] >= g[i]) {
				contentChildren++;
				i--;
				j--;
			}
			else {
				i--;
			}
		}
		
		return contentChildren;
	}
	
	private static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];	
		}
	}
	
	public static void main(String[] argv) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		
		System.out.println(findContentChildren(g,s));
	}

}
