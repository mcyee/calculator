/**
 * Project: Calculator
 * File: Calculator.java
 *
 * @author Ming-Cee Yee
 *
 * Date Created: June 10, 2013
 * Last Modified: 2014-05-08
 * Description: 
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Calculator extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private String equation = "";
	private String term = "";
	private ArrayList<Integer> terms = new ArrayList<Integer>();
	private ArrayList<String> operators = new ArrayList<String>();
	
	private JPanel panel;
	private JMenuBar menu;
	private JTextArea output;
	private JScrollPane scrollPane;
	
	private GridLayout buttons;
	private JPanel buttonsPanel;
	private JButton[] numbers;
	
	private JButton add;
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	private JButton equal;
	

	public Calculator()
	{
		initUI();
	}
	
	/**
	 * initUI() generates the GUI of the application
	 * PRE: true
	 * POST: application GUI is generated
	 */
	public final void initUI()
	{
	    
	    // internal elements
		panel = new JPanel();
		
		addMenu();
		addOutput(panel);
		addButtons(panel);
		getContentPane().add(panel, BorderLayout.PAGE_START);
		getContentPane().add(buttonsPanel, BorderLayout.CENTER);

		// window elements
		setTitle("Calculator");
		setSize(300, 400);
		setLocationRelativeTo(null); // centres app
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
	}

    /**
     * addMenu() adds the menu bar at the top of the application
     * PRE: true
     * POST: menu for application is generated
     */
	public final void addMenu()
	{
		menu = new JMenuBar();
		
		// "File" menu
		JMenu file;
			JMenuItem fileQuit;
		
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
	
		    // "Quit" item in "File"
			fileQuit = new JMenuItem("Quit");
			fileQuit.setMnemonic(KeyEvent.VK_Q);
			fileQuit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
			});
			
		file.add(fileQuit);
		
		menu.add(file);
		setJMenuBar(menu);
		
	}
	
	/**
	 * addOutput(panel) adds text area output display to `panel`
	 * PRE: true
	 * POST: text area is added to `panel`
	 */
	public final void addOutput(JPanel panel)
	{
		output = new JTextArea();
		scrollPane = new JScrollPane(output);
		scrollPane.setPreferredSize(new Dimension(250, 40));
		output.setEditable(false);
		output.setFont(new Font("Serif", Font.PLAIN, 24));
		
		panel.add(scrollPane);
	}

	/**
	 * addButtons(panel) adds buttons to `panel` (basic operators and 0-9)
	 * PRE: true
	 * POST: generates buttons on `panel`
	 */
	public final void addButtons(JPanel panel)
	{
		buttons = new GridLayout(5, 3);
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(buttons);
		numbers = new JButton[10];

		// adds numeric buttons
		int i = 0;
		for (JButton n : numbers)
		{
			String s = "" + i;
			n = new JButton(s);
			n.setMnemonic(KeyEvent.KEY_RELEASED);
			n.addActionListener(this);
			buttonsPanel.add(n);
			i++;
		}

		// adds operator buttons
		add = new JButton("+");
		add.setMnemonic(KeyEvent.KEY_RELEASED);
		add.addActionListener(this);
		subtract = new JButton("-");
		subtract.setMnemonic(KeyEvent.KEY_RELEASED);
		subtract.addActionListener(this);
		multiply = new JButton("*");
		multiply.setMnemonic(KeyEvent.KEY_RELEASED);
		multiply.addActionListener(this);
		divide = new JButton("/");
		divide.setMnemonic(KeyEvent.KEY_RELEASED);
		divide.addActionListener(this);
		equal = new JButton("=");
		equal.setMnemonic(KeyEvent.KEY_RELEASED);
		equal.addActionListener(this);
		
		buttonsPanel.add(add);
		buttonsPanel.add(subtract);
		buttonsPanel.add(multiply);
		buttonsPanel.add(divide);
		buttonsPanel.add(equal);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Calculator c = new Calculator();
				c.setVisible(true);
			}
		});
	}

	/**
	 * actionPerformed(e) does something I don't remember. I think it's supposed
	 *   to be the actual functionality thing.
	 * PRE: ?
	 * POST: ?
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		//**********************************
		//       When button is clicked
		//**********************************
		JButton button = (JButton)e.getSource();
		String s = button.getText();
		output.setText(s);
		equation += s;
		
		int substring;
		
		System.out.println(equation);
		
		for (int i = 0; i < equation.length(); i++)
		{
			if (Character.isDigit(equation.charAt(i)))
			{
				term += Character.toString(equation.charAt(i));
			}
			
			else
			{
				break;
			}
			
			substring = i;
		}
		
		terms.add(Integer.parseInt(term));
	}

}
