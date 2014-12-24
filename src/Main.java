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
		// stack for input
		ArrayDeque<Expression> exprList = new ArrayDeque<Expression>();
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext() && !scan.next().equals("EOF"))
		{
			String s = scan.next();
			char c = s.charAt(0);
			
			// loneint
			if ('0' <= c && c <= '9')
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
				//TODO finish this
			}
		}
		
		scan.close();
		
		System.out.println(exprList.peek().evaluate());
	}

}
