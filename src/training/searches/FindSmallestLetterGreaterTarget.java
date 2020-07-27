package training.searches;

public class FindSmallestLetterGreaterTarget {
	
	public static char nextGreatest(char[] letters, char target) {
	
		int l=0, r = letters.length-1;
		
		while(l < r && letters[r] > target) {
			int mid = (l+r) >> 1;
			if(letters[mid] > target) r = mid;
			else l = mid + 1;
		}
		
		return letters[l];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'c','f','j'};
		char target = 'g';
		
		System.out.println(nextGreatest(c,target));
	}

}
