/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Sep 1, 2015
 * Description: Representation of an expression in infix notation
 */

import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class InfixExpr {

	private String expr;
	
	public InfixExpr(String e) {
		expr = e;
	}
	
	/**
	 * getRPN() converts the InfixExpr into Reverse Polish Notation
	 */
	public String getRPN() {
		String rpnExpr = "";
		
		//TODO implement
		ArrayDeque<String> outputQueue = new ArrayDeque<String>();
		ArrayDeque<String> operatorStack = new ArrayDeque<String>();
		StringTokenizer st = new StringTokenizer(expr);
		
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
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
			// handle separators (parentheses)
			else {
				// pops operators off the stack onto the queue until
				// a "(" is reached
				while (operatorStack.peekLast() != "(") {
					outputQueue.add(operatorStack.removeLast());
				}
			}
		}
			
		return rpnExpr;
	}

}
