package itexico.training.pilas.implementation.generics;

public class SortStack {

	public Stack<Integer> sort(Stack<Integer> input) 
			throws StackUnderFlowException, StackOverflowException{
		Stack<Integer> tmpStack = new Stack<Integer>();
		int tmp;
		
		System.out.println("=============== debug logs ================");
		while (!input.isEmpty()) {
			tmp = input.pop();
			System.out.println("Element taken out: " + tmp);
			
			while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)  
				input.push(tmpStack.pop());
			
			tmpStack.push(tmp);
			System.out.println("Input: " + input);
			System.out.println("Temp Stack: " + tmpStack);
		}
		System.out.println("=============== debug logs ended================");
		return tmpStack;
	}
	
	public static void main(String[] ar) 
			throws StackOverflowException, StackUnderFlowException {
		SortStack s = new SortStack();
		Stack<Integer> input = new Stack<Integer>();
		input.push(34);
		input.push(2);
		input.push(31);
		input.push(98);
		input.push(92);
		input.push(93);
		
		System.out.println("Input: " + input);
		System.out.println("Sorted List: " + s.sort(input));
	}
}
