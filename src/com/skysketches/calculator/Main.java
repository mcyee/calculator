/**
 * Project: Calculator
 * Author: Ming-Cee Yee
 * Created: Dec 23, 2014
 * Description: Main class that runs the calculator.
 */

package com.skysketches.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<InfixExpr> infixExpressions = new ArrayList<InfixExpr>(); // list of expressions
		File file = new File("/tst/input1.txt");
		
		/**
		 * reads file
		 * assumes each line of the file is a full, correct expression
		 */
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			
			while (br.ready()) {
				String line = br.readLine(); // get entire expression
				infixExpressions.add(new InfixExpr(line));
			}
		}
		
		/**
		 * Reverse Polish notation parsing
		 */
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
	}
}
