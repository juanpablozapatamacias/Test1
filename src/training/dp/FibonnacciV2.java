package training.dp;

public class FibonnacciV2 {
	
	public static int fib(int n) {
		int first=0,second=1,sum=0;
		
		if(n<2) return n;
		
		for(int i=2;i<=n;i++) {
			sum = first+second;
			first =second;
			second =sum;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(10));
	}

}
