/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: Representation of a binary operation (addition, subtraction,
 *              multiplication, division)
 */

public class BinaryOp extends Expression {

	private String binaryOper;
	private Expression leftOperand;
	private Expression rightOperand;
	
	public BinaryOp(String oper, Expression left, Expression right) {
		super();
		binaryOper = oper;
		leftOperand = left;
		rightOperand = right;
	}
	
	/**
	 * prettyprint() returns Expression in a nice format
	 */
	@Override
	public String prettyprint() {
		return "(" + leftOperand.prettyprint() + binaryOper
		       + rightOperand.prettyprint() + ")";
	}
	
	/**
	 * evaluate() returns the actual value of the Expression
	 */
	@Override
	public int evaluate() {
		int value = 0;
		
		switch (binaryOper) {
			case "+": // addition
				value = leftOperand.evaluate() + rightOperand.evaluate();
				break;
			case "-": // subtraction
				value = leftOperand.evaluate() - rightOperand.evaluate();
				break;
			case "*": // multiplication
				value = leftOperand.evaluate() * rightOperand.evaluate();
				break;
			default: // "/" division
				try {
					if (rightOperand.evaluate() == 0) {
						throw new ArithmeticException();
					}
					value = leftOperand.evaluate() / rightOperand.evaluate();
				}
				catch (ArithmeticException e) {
					System.out.println("Cannot divide by zero");
				}
				break;
		}
		
		return value;
	}

}
