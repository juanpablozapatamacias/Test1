package itexico.training.pilas.implementation.generics;

import itexico.training.colas.implementation.generics.QueueOverflowException;
import itexico.training.colas.implementation.generics.QueueUnderflowException;

public class QueueTwoStacks<T> {
	 private Stack<T> forwardStack = new Stack<>();
	 private Stack<T> reverseStack = new Stack<>();
	 
	 public QueueTwoStacks() {}

	 public boolean isFull() {
		 return forwardStack.isFull() || reverseStack.isFull();
	 }
	 
	 public boolean isEmpty(){
		 return forwardStack.isEmpty() && reverseStack.isEmpty(); 
	 }
	 
	 public void enqueue(T data) throws QueueOverflowException{
		 if (isFull()) throw new QueueOverflowException();
		 
		 try {
			 if(forwardStack.isEmpty()) {
				 while(!reverseStack.isEmpty()) {
					 forwardStack.push(reverseStack.pop());
				 }
			 }
			 forwardStack.push(data);
		 }
		 catch(StackOverflowException | StackUnderFlowException e) {
			 throw new QueueOverflowException();
		 }
	 }
	 
	 public T dequeue() throws QueueUnderflowException{
		 if(isEmpty()) throw new QueueUnderflowException();
		 
		 try {
			 if(reverseStack.isEmpty()) {
				 while(!forwardStack.isEmpty()) {
					 reverseStack.push(forwardStack.pop());
				 }
			 }
			 return reverseStack.pop();
		 }
		 catch(StackOverflowException | StackUnderFlowException se) {
			 throw new QueueUnderflowException();
		 }
	 }
}
