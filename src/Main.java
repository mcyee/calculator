/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: Main class that runs the calculator.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = null;
		ArrayList<InfixExpr> infixExpressions = new ArrayList<InfixExpr>(); // list of expressions
		
		/**
		 * reads file
		 * assumes each line of the file is a full, correct expression
		 */
		try {
			scan = new Scanner(new BufferedReader(new FileReader("../tst/input1.txt")));
			
			while (scan.hasNext()) {
				//TODO fix stuff
				String line = scan.nextLine(); // get entire expression
				infixExpressions.add(new InfixExpr(line));
			}
		}
		finally {
			if (scan != null) {
				scan.close();
			}
		}
		
		/**
		 * Reverse Polish notation parsing
		 */
		//TODO finish processing rpn
		// list of Expression trees
		ArrayList<Expression> expressions = new ArrayList<Expression>();
		for (InfixExpr ie : infixExpressions) {
			RPNExpr rpn = new RPNExpr(ie.getRPN());
			expressions.add(rpn.createExpression());
		}
		
		/**
		 * Print evaluation (calculated value) of given expression
		 */
		for (Expression e : expressions) {
			System.out.println(e.prettyprint()+ " = " + e.evaluate());
		}
//		System.out.println(exprList.peek().evaluate());
	}
}
