/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Sep 1, 2015
 * Description: Representation of an expression in infix notation
 * References: https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 *             http://rosettacode.org/wiki/Parsing/Shunting-yard_algorithm#Java
 *             http://eddmann.com/posts/shunting-yard-implementation-in-java/
 */

package com.skysketches.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixExpr {

	private String expr;
	
	public InfixExpr(String e) {
		expr = e;
	}
	
	/**
	 * Valid operators and their precedences
	 */
	private enum Operator {
		ADD      (1),
		SUBTRACT (2),
		MULTIPLY (3),
		DIVIDE   (4);
		
		final int precedence;
		
		Operator(int p) {
			precedence = p;
		}
	}
	
	/**
	 * Valid functions
	 */
	private enum Function {
		NEGATION,
		ABSOLUTEVALUE;
	}
	
	/**
	 * Map of symbols to their respective operators
	 */
	private static Map<String, Operator> ops = new HashMap<String, Operator>(){
		private static final long serialVersionUID = -4931774982280911450L;
	{
		put("+", Operator.ADD);
		put("-", Operator.SUBTRACT);
		put("*", Operator.MULTIPLY);
		put("/", Operator.DIVIDE);
	}};
	
	/**
	 * Map of symbols to their respective functions
	 */
	private static Map<String, Function> functions = new HashMap<String, Function>() {
		private static final long serialVersionUID = -6495730501768339133L;
	{
		put("NEG", Function.NEGATION);
		put("ABS", Function.ABSOLUTEVALUE);
	}};
	
	/**
	 * isHigherPrecedence() returns true if op has a higher precedence than sub
	 */
	private static boolean isHigherPrecedence(String o1, String o2) {
		return (ops.containsKey(o2) && ops.get(o2).precedence >= ops.get(o1).precedence);
	}
	
	/**
	 * getRPN() converts the InfixExpr into Reverse Polish Notation
	 * Follows implementation references as listed in class header (above)
	 */
	public String getRPN() {
		StringBuilder output = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(expr);
		
		while (st.hasMoreTokens()) {
			String s = st.nextToken();

			// push operator onto the stack if it has higher precedence
			// assumes there are no right-associative operators
			if (ops.containsKey(s)) {
				while (!stack.isEmpty() && isHigherPrecedence(s, stack.peek())) {
					output.append(stack.pop()).append(' ');
				}
				stack.push(s);
			}
			// push function onto the stack
			else if (functions.containsKey(s)) {
				stack.push(s);
			}
			// push left parenthesis onto the stack
			else if (s.equals("(")){
				stack.push(s);
			}
			// on reaching right parenthesis, pop tokens off the stack onto the
			// output queue until left parenthesis
			else if (s.equals(")")) {
				while (!stack.peek().equals("(")) {
					output.append(stack.pop()).append(' ');
					
					if (stack.isEmpty()) {
						System.err.println("Mismatched parentheses");
					}
				}
				stack.pop(); // pop left parenthesis
			}
			// push integer on the output queue
			else {
				output.append(s);
			}
			
			// pop the rest of the operators off the stack onto the output queue
			while (!stack.isEmpty()) {
				if (stack.peek().equals("(") || stack.peek().equals(")")) {
					System.err.println("Mismatched parentheses");
				}
				
				output.append(stack.pop()).append(' ');
			}
		}
			
		return output.toString();
	}

}
