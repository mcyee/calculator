/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Sep 1, 2015
 * Description: Representation of an expression in infix notation
 * Reference: http://eddmann.com/posts/shunting-yard-implementation-in-java/
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InfixExpr {

	private String expr;
	
	public InfixExpr(String e) {
		expr = e;
	}
	
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
	
	//TODO follow reference
	
	/**
	 * isInteger() returns true if str can be converted into an integer
	 *     (does not account for overflow)
	 * Reference: http://stackoverflow.com/questions/237159/whats-the-best-way-to-check-to-see-if-a-string-represents-an-integer-in-java
	 */
	private static boolean isInteger(String str) {
		if (str == null) return false;
		int length = str.length();
		if (length == 0) return false;
		
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) return false;
			i = 1;
		}
		for(; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || '9' < c) return false;
		}
		return true;
	}
	
	/**
	 * getRPN() converts the InfixExpr into Reverse Polish Notation
	 */
	public String getRPN() {
		String rpnExpr = "";
		
		ArrayList<String> operators = new ArrayList<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		operators.add("NEG");
		operators.add("ABS");
		
		ArrayDeque<String> outputQueue = new ArrayDeque<String>();
		ArrayDeque<String> operatorStack = new ArrayDeque<String>();
		StringTokenizer st = new StringTokenizer(expr);
		
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			
			// push integer on the output queue
			if (isInteger(s)) {
				outputQueue.add(s);
			}
			// push operator on the operator stack
			else if (operators.contains(s)) {
				operatorStack.push(s);
			}
			//TODO fix
			// handle separators (parentheses)
			else {
				// pops operators off the stack onto the queue until
				// a "(" is reached
				while (operatorStack.peekLast() != "(") {
					outputQueue.add(operatorStack.removeLast());
				}
			}
			// If the token is an operator, o1, then:
				// while there is an operator token, o2, at the top of the operator stack, and either
					// o1 is left-associative and its precedence is less than or equal to that of o2, or
					// o1 is right associative, and has precedence less than that of o2,
				// then pop o2 off the operator stack, onto the output queue;
				// push o1 onto the operator stack.
			// If the token is a left parenthesis (i.e. "("), then push it onto the stack.
			// If the token is a right parenthesis (i.e. ")"):
				// Until the token at the top of the stack is a left parenthesis, pop operators off the stack onto the output queue.
				// Pop the left parenthesis from the stack, but not onto the output queue.
				// If the token at the top of the stack is a function token, pop it onto the output queue.
				// If the stack runs out without finding a left parenthesis, then there are mismatched parentheses.
			// When there are no more tokens to read:
				// While there are still operator tokens in the stack:
					// If the operator token on the top of the stack is a parenthesis, then there are mismatched parentheses.
					// Pop the operator onto the output queue.
			// Exit.
		}
			
		return rpnExpr;
	}

}
