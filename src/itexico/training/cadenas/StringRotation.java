package itexico.training.cadenas;

public class StringRotation {

	public static boolean isStringRotated(String A, String B) {
		return A.length() != B.length() && (A+A).contains(B);
	}
	
	public static void main(String[] argv) {
		System.out.println(isStringRotated("abcde","abced"));
	}
}
