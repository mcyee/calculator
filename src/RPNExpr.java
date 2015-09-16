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

			// push UnaryOp on the stack
			if (c == 'N' || c == 'A') {
				Expression last = exprList.pop();
				exprList.push(new UnaryOp(s, last));
			}
			// push BinaryOp on the stack
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				Expression right = exprList.pop();
				Expression left = exprList.pop();
				exprList.push(new BinaryOp(s, left, right));
			}
			// push LoneInt on the stack
			else {
				exprList.push(new LoneInt(Integer.parseInt(s)));
			}
		}
		
		return exprList.getLast();
	}
}
