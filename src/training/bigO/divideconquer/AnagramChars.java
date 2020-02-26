package training.bigO.divideconquer;

public class AnagramChars {

	public static boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		mergeSort(c1);
		mergeSort(c2);
		
		for(int i=0;i<c1.length;i++) {
			if(c1[i] == c2[i]) continue;
			else return false;
		}
		
		return true;
	}
	
	
	private static void mergeSort(char[] arr) {
		int n = arr.length;
		int mid = n / 2;
		
		char[] l = new char[mid];
		char[] r = new char[n-mid];
		
		if(n>=2) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j]; 
			
			mergeSort(l);
			mergeSort(r);
			merge(arr,l,r,mid,n-mid);
		}
	}
	
	private static void merge(char[] arr, char[] l, char[] r, int left, int right) {
		int i=0,j=0,k=0;
		
		while(i<left && j<right) {
			if(l[i] <= r[j]) arr[k++] = l[i++];
			else arr[k++] = r[j++];
		}
		
		while(i<left) arr[k++] = l[i++];
		while(j<right) arr[k++] = r[j++];
		
	}


	public static void main(String[] args) {
		String s1 = "atun";
		String s2 = "tuna";
		
		System.out.println(isAnagram(s1,s2) ? "Es anagrama" : "No es anagrama");

	}

}
