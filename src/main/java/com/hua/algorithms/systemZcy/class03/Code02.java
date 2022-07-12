package com.hua.algorithms.systemZcy.class03;

import java.util.Objects;
import java.util.Stack;

public class Code02 {

	public static class MyStack {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if(stackMin.isEmpty()){
				stackMin.push(newNum);
			} else if(newNum <= getmin()){
				stackMin.push(newNum);
			}

			stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			Integer value = stackData.pop();
			if(Objects.equals(value, getmin())){
				stackMin.pop();
			}

			return value;

		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return stackMin.peek();
		}
	}


	public static void main(String[] args) {
		MyStack stack1 = new MyStack();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());


	}

}
