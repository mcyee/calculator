/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

public class BinaryOp extends Expression {

	private String binaryOper;
	private Expression leftOperand;
	private Expression rightOperand;
	
	public BinaryOp(String oper, Expression left, Expression right)
	{
		super();
		binaryOper = oper;
		leftOperand = left;
		rightOperand = right;
	}
	
	/**
	 * prettyprint() returns Expression in a nice format
	 */
	@Override
    public String prettyprint()
	{
		return "(" + leftOperand.prettyprint() + binaryOper
		       + rightOperand.prettyprint() + ")";
	}
	
	/**
	 * evaluate() returns the actual value of the Expression
	 */
	@Override
    public int evaluate()
	{
		//TODO check for divide by zero
		int value = 0;
		
		switch (binaryOper) {
			case "+":
				value = leftOperand.evaluate() + rightOperand.evaluate();
				break;
			case "-":
				value = leftOperand.evaluate() - rightOperand.evaluate();
				break;
			case "*":
				value = leftOperand.evaluate() * rightOperand.evaluate();
				break;
			default: // "/"
				value = leftOperand.evaluate() / rightOperand.evaluate();
				break;
		}
		
		return value;
	}

}
