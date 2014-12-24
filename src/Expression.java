/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

public abstract class Expression {
	abstract String prettyprint(); // returns Expression in a nice format
	abstract int evaluate(); // returns the actual value of the Expression
}
