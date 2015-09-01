/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Sep 1, 2015
 * Description: Representation of an expression in reverse polish notation
 */

import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RPNExpr {

	String expr;
	
	public RPNExpr(String e) {
		expr = e;
	}

	/**
	 * createExpression() creates an Expression from the RPNExpr
	 */
	public Expression createExpression() {
		ArrayDeque<Expression> exprList = new ArrayDeque<Expression>();
		StringTokenizer st = new StringTokenizer(expr);
		
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			char c = s.charAt(0);
			
			// push LoneInt on the stack
			if (('0' <= c && c <= '9') || c == '-') {
				exprList.push(new LoneInt(Integer.parseInt(s)));
			}
			// push BinaryOp on the stack
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				Expression right = exprList.pop();
				Expression left = exprList.pop();
				exprList.push(new BinaryOp(s, left, right));
			}
			// push UnaryOp on the stack
			else {
				Expression last = exprList.pop();
				exprList.push(new UnaryOp(s, last));
			}
		}
		
		return exprList.getLast();
	}
}
