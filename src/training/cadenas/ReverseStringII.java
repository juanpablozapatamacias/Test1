package training.cadenas;

public class ReverseStringII {
	
	public static String reverse(String s, int k) {
		char[] arr = s.toCharArray();
		char temp;
		
		int innerStart,innerEnd;
		
		for (int start = 0;start< arr.length;start += 2*k) {
			innerStart = start;
			innerEnd = Math.min(innerStart + k - 1, arr.length-1);
			
			while(innerStart < innerEnd) {
				temp = arr[innerStart];
				arr[innerStart++] = arr[innerEnd];
				arr[innerEnd--] = temp;
				
			}
		}
		
		return new String(arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg";
		int k = 2;
		
		System.out.println(reverse(s,k));
	}

}
