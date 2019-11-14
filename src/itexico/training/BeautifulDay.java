package itexico.training;

public class BeautifulDay {
	static int beautifulDays(int a, int b, int k) {
		int bdays = 0;
		for (int i=a;i<=b;i++) {
			StringBuilder day = new StringBuilder(String.valueOf(i));
			//int aReverse = Integer.parseInt(day.reverse().toString());
			int aReverse = reverse(i);
			
			if(Math.abs(a-aReverse) % k == 0) bdays++;
		}
		return bdays;
	}
	
	public static int reverse(int n) {
		int temp=0;
		while (n != 0) {
			temp *=10;
			temp += n % 10;
			n/=10;
		}
		return temp;
	}
	
	public static void main(String[] a) {
		System.out.println(beautifulDays(13,45,3));
	}

}
