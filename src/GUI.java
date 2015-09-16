import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends Frame {
	public GUI() {
		setTitle("Calculator");

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		setLayout(gridbag);

		//So the window will close when we click exit
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		setSize(400,400);

		//
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		/*
		 * DISPLAY LABEL
		 */
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		TextField display = new TextField("Display here :^)");
		gridbag.setConstraints(display, gbc);
		add(display);

		gbc.gridwidth = 1;
		
		/*
		 * FIRST ROW OF BUTTONS
		 */
		gbc.gridx = 0;
		gbc.gridy = 1;
		Button clear = new Button("Clear");
		gridbag.setConstraints(clear, gbc);
		add(clear);

		gbc.gridx = 1;
		gbc.gridy = 1;
		Button backspace = new Button("Backspace");
		gridbag.setConstraints(backspace, gbc);
		add(backspace);

		gbc.gridx = 2;
		gbc.gridy = 1;
		Button abs = new Button("Abs");
		gridbag.setConstraints(abs, gbc);
		add(abs);

		gbc.gridx = 3;
		gbc.gridy = 1;
		Button divide = new Button("/");
		gridbag.setConstraints(divide, gbc);
		add(divide);

		/*
		 * SECOND ROW OF BUTTONS
		 */
		gbc.gridx = 0;
		gbc.gridy = 2;
		Button digit7 = new Button("7");
		gridbag.setConstraints(digit7, gbc);
		add(digit7);

		gbc.gridx = 1;
		gbc.gridy = 2;
		Button digit8 = new Button("8");
		gridbag.setConstraints(digit8, gbc);
		add(digit8);

		gbc.gridx = 2;
		gbc.gridy = 2;
		Button digit9 = new Button("9");
		gridbag.setConstraints(digit9, gbc);
		add(digit9);

		gbc.gridx = 3;
		gbc.gridy = 2;
		Button multiply = new Button("*");
		gridbag.setConstraints(multiply, gbc);
		add(multiply);

		/*
		 * THIRD ROW OF BUTTONS
		 */
		gbc.gridx = 0;
		gbc.gridy = 3;
		Button digit4 = new Button("4");
		gridbag.setConstraints(digit4, gbc);
		add(digit4);

		gbc.gridx = 1;
		gbc.gridy = 3;
		Button digit5 = new Button("5");
		gridbag.setConstraints(digit5, gbc);
		add(digit5);

		gbc.gridx = 2;
		gbc.gridy = 3;
		Button digit6 = new Button("6");
		gridbag.setConstraints(digit6, gbc);
		add(digit6);

		gbc.gridx = 3;
		gbc.gridy = 3;
		Button subtract = new Button("-");
		gridbag.setConstraints(subtract, gbc);
		add(subtract);

		/*
		 * FOURTH ROW OF BUTTONS
		 */
		gbc.gridx = 0;
		gbc.gridy = 4;
		Button digit1 = new Button("1");
		gridbag.setConstraints(digit1, gbc);
		add(digit1);

		gbc.gridx = 1;
		gbc.gridy = 4;
		Button digit2 = new Button("2");
		gridbag.setConstraints(digit2, gbc);
		add(digit2);

		gbc.gridx = 2;
		gbc.gridy = 4;
		Button digit3 = new Button("3");
		gridbag.setConstraints(digit3, gbc);
		add(digit3);

		gbc.gridx = 3;
		gbc.gridy = 4;
		Button plus = new Button("+");
		gridbag.setConstraints(plus, gbc);
		add(plus);

		/*
		 * FIFTH ROW OF BUTTONS
		 */
		gbc.gridx = 0;
		gbc.gridy = 5;
		Button digit0 = new Button("0");
		gridbag.setConstraints(digit0, gbc);
		add(digit0);

		gbc.gridx = 1;
		gbc.gridy = 5;
		Button decimal = new Button(".");
		gridbag.setConstraints(decimal, gbc);
		add(decimal);

		gbc.gridx = 2;
		gbc.gridy = 5;
		Button ans = new Button("Ans");
		gridbag.setConstraints(ans, gbc);
		add(ans);

		gbc.gridx = 3;
		gbc.gridy = 5;
		Button equals = new Button("=");
		gridbag.setConstraints(equals, gbc);
		add(equals);


		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}
}