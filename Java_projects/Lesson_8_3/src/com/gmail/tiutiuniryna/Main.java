package com.gmail.tiutiuniryna;

public class Main {

	public static void main(String[] args) {
		ArrayBasedStack stack = new ArrayBasedStack();
		stack.push("Hello");
		stack.push("Java");
		stack.push("Stack");
		System.out.println(stack);
		for(;stack.peek()!=null;) {
			System.out.println(stack.pop());
		}
	}

}
