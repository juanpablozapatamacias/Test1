package training.pilas.notacionpolaca;

import java.util.EmptyStackException;

public class AppRPN {
	
	/*
	 * 
	 * Removes all chars not valid in the expression
	 * 
	 * 
	 * 
	 * */
	
	private static String parseExpression(String exp) {
		String parsedExpr = exp.replace("[^\\\\^\\\\*\\\\+\\\\-\\\\d/\\\\s]", "");
		String trimmedExp = parsedExpr.replace("\\s+", "");
		return trimmedExp;
	}
	
	public static void compute(String exp) 
			throws ArithmeticException,EmptyStackException  {
		String validExp = parseExpression(exp);
		
		PilaArray pi = new PilaArray();
		
		System.out.println(exp);
		System.out.println("Input\\tOperation\\tStack after");
		
		for(String token : exp.split("\\s+")) {
			System.out.println(token);
			
			switch(token) {
				case "+":
					System.out.println("Operate\t\t");
					pi.push((int)pi.pop() + (int)pi.pop());
					break;
				case "-":
					System.out.println("Operate\t\t");
					pi.push(-(int)pi.pop() + (int)pi.pop());
					break;
				case "*":
					System.out.println("Operate\t\t");
					pi.push((int)pi.pop() * (int)pi.pop());
					break;
				case "/":
					System.out.println("Operate\t\t");
					int divisor = (int)pi.pop();
					pi.push((int)pi.pop() / divisor);
					break;
				case "^":
					System.out.println("Operate\t\t");
					int exponent = (int)pi.pop();
					pi.push((int)pi.pop() ^ exponent);
					break;
				default:
					pi.push(Integer.parseInt(token));
					break;
			}
			System.out.println(pi);
		}
		System.out.println("Final answer: " + pi.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ex = "3 5 +";
		compute(ex);
	}

}
