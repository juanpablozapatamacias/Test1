package training;

public class Programmer {
	static String dayProg(int y) {
		String date = "";
		
		if(y < 1918) date+=(y % 4 == 0) ? "12.09."+y : "13.09."+y;
		else if(y == 1918) date+="26.09."+y;
		else date += ((y % 400 == 0) || (y % 4 == 0 && y % 100 !=0)) ? "12.09."+y : "13.09."+y;
		
		return date;
	}

	public static void main(String[] ar) {
		System.out.println(dayProg(1917));
	}
}
