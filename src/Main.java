/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: 
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		ArrayDeque<String> outputQueue = new ArrayDeque<String>();
		ArrayDeque<String> outputStack = new ArrayDeque<String>();
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext())
		{
			String s = scan.next();
			
			if (s.equals("EOF")) break;
			
			
		}
		
		/**
		 * Reverse Polish notation parsing
		 */
		// stack for input
		ArrayDeque<Expression> exprList = new ArrayDeque<Expression>();
		
		while (scan.hasNext())
		{
			String s = scan.next();
			
			if (s.equals("EOF")) break;
		
			char c = s.charAt(0);
			
			// loneint
			if (('0' <= c && c <= '9') || c == '-')
			{
				exprList.push(new LoneInt(Integer.parseInt(s)));
			}
			// binaryop
			else if (c == '+' || c == '-' || c == '*' || c == '/')
			{
				Expression right = exprList.pop();
				Expression left = exprList.pop();
				exprList.push(new BinaryOp(s, left, right));
			}
			else // unaryop
			{
				Expression last = exprList.pop();
				exprList.push(new UnaryOp(s, last));
			}
		}
		
		scan.close();
		System.out.println(exprList.peek().evaluate());
	}
}
