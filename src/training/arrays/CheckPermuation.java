package training.arrays;

public class CheckPermuation {

	public static boolean isPermutation(String a, String b) {
	
		if(a.length()!=b.length()) return false;
		
		String sortedA = quickSort(a);
		String sortedB = quickSort(b);
		
		for(int i=0;i<a.length();i++) {
			if(sortedA.charAt(i) != sortedB.charAt(i)) return false;
		}
		
		return true;
	}
	
	public static String quickSort(String str) {
		if(str == null || str.length()==0 || str.length()==1) return null;
		
		char[] chars = str.toCharArray();
		quickSort(chars,0,chars.length-1);
		return new String(chars);
	}
	
	private static void quickSort(char[] chars, int low, int high) {
		int i = low;
		int j = high;
		char tmp;
		
		int pivot = low + (high-low) / 2;
		
		while (i<=j) {
			while(chars[i] < chars[pivot]) i++;
			while(chars[j] > chars[pivot]) j--;
			
			if(i<=j) {
				tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				i++;
				j--;
			}
		}
		
		if (low < j) quickSort(chars,low,j);
		if (i < high) quickSort(chars,i,high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPermutation("bbabcdef","fedcbabb") ? "Permutation" : "Not Permutation");
	}

}
