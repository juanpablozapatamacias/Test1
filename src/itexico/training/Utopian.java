package itexico.training;

public class Utopian {

	public static int utopianTree(int n) {
		int height = 1;
		for(int i=0;i<n;i++) {
			if(i % 2 == 0) height *= 2;
			else height +=1;
		}
		return height;
	}
	
	public static void main(String[] ar) {
		System.out.println(utopianTree(0));
		System.out.println(utopianTree(1));
		System.out.println(utopianTree(4));
	}
}
