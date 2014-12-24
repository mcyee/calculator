/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

public class UnaryOp extends Expression {

	private String unaryOper;
	private Expression operand;
	
	public UnaryOp(String unary, Expression oper)
	{
		super();
		unaryOper = unary;
		operand = oper;
	}
	
	/**
	 * prettyprint() returns Expression in a nice format
	 */
	@Override
    public String prettyprint()
	{
		// TODO finish this
		return "";
	}
	
	/**
	 * evaluate() returns the actual value of the Expression
	 */
	@Override
    public int evaluate()
	{
		// TODO finish this
		return 0;
	}

}
