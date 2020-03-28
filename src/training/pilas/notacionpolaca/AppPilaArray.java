package training.pilas.notacionpolaca;

public class AppPilaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPila pa = new PilaArray();
		
		pa.push(4);
		pa.push(2);
		pa.push(3);
		
		System.out.println(pa.pop());
		System.out.println(pa.pop());
		System.out.println(pa.pop());
	}

}
