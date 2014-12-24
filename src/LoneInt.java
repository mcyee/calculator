/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

public class LoneInt extends Expression {

	private int number;
	
	public LoneInt(int n)
	{
		super();
		number = n;
	}
	
	/**
	 * prettyprint() returns the Expression in a nice format
	 */
	@Override
    public String prettyprint()
	{
		return String.valueOf(this.number);
	}
	
	/**
	 * evaluate() returns the Expression's value
	 */
	@Override
    public int evaluate()
	{
		return this.number;
	}
}
