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
		String printedOper = operand.prettyprint();
		
		if (unaryOper.equals("NEG"))
		{
			if (printedOper.charAt(0) == '-')
				return printedOper.substring(1);
			else
				return "-" + printedOper;
		}
		else // unaryOper.equals("ABS")
		{
			return "|" + printedOper + "|";
		}
	}
	
	/**
	 * evaluate() returns the actual value of the Expression
	 */
	@Override
    public int evaluate()
	{
		int evalOper = operand.evaluate();
		
		if (unaryOper.equals("NEG"))
		{
			return evalOper * -1;
		}
		else // unaryOper.equals("ABS")
		{
			if (evalOper < 0)
			{
				return evalOper * -1;
			}
			else
			{
				return evalOper;
			}
		}
	}

}
