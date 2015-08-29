/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayDeque<String> outputQueue = new ArrayDeque<String>();
		ArrayDeque<String> operatorStack = new ArrayDeque<String>();
		Scanner scan = null;
		
		try {
			scan = new Scanner(new BufferedReader(new FileReader("input.txt")));
			
			/**
			 * infix notation parsing
			 */
			while (scan.hasNext()) {
				String s = scan.next();
				
				if (s.equals("EOF")) break;
				// TODO implement shunting yard algo

				char c = s.charAt(0);
				
				// push integer on the output queue
				if (('0' <= c && c <= '9') || c == '-') {
					outputQueue.add(s);
				}
				// push operator on the operator stack
				else if (c == '+' || c == '-' || c == '*' || c == '/'
				      || c == 'N' || c == 'A') {
					operatorStack.push(s);
				}
				// handle separators (paraentheses)
				else {
					// pops operators off the stack onto the queue until
					// a "(" is reached
					while (operatorStack.peekLast() != "(") {
						outputQueue.add(operatorStack.removeLast());
					}
				}
			}
		}
		finally {
			if (scan != null) {
				scan.close();
			}
		}
		
		/**
		 * Reverse Polish notation parsing
		 */
//		// stack for input
//		ArrayDeque<Expression> exprList = new ArrayDeque<Expression>();
//		
//		while (scan.hasNext()) {
//			String s = scan.next();
//			
//			if (s.equals("EOF")) break;
//		
//			char c = s.charAt(0);
//			
//			// push LoneInt on the stack
//			if (('0' <= c && c <= '9') || c == '-') {
//				exprList.push(new LoneInt(Integer.parseInt(s)));
//			}
//			// push BinaryOp on the stack
//			else if (c == '+' || c == '-' || c == '*' || c == '/') {
//				Expression right = exprList.pop();
//				Expression left = exprList.pop();
//				exprList.push(new BinaryOp(s, left, right));
//			}
//			// push UnaryOp on the stack
//			else {
//				Expression last = exprList.pop();
//				exprList.push(new UnaryOp(s, last));
//			}
//		}
//		
//		scan.close();
		
		/**
		 * Print evaluation (calculated value) of given expression
		 */
		System.out.println(exprList.peek().evaluate());
	}
	
	/**
	 * Convert infix notation to postfix (reverse polish notation)
	 * @param infix
	 * @return
	 */
	static String infixToPostfix(String infix) {
		
	}
}
