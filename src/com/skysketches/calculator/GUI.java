/**
 * Project: Calculator
 * Author: Tristan Ohlson
 * Created: Sep 16, 2015
 * Description:
 */

package com.skysketches.calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	
	@Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Calculator");

    	//Set layout properties
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(15, 15, 15, 15));

    	Scene scene = new Scene(grid, 300, 300);
    	primaryStage.setScene(scene);
    	
    	//Load CSS
    	scene.getStylesheets().add(this.getClass().getResource("GUI.css").toExternalForm());
    	
    	Button infix = new Button("Infix");
    	infix.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	HBox hbinfix = new HBox(10);
    	hbinfix.setAlignment(Pos.BOTTOM_LEFT);
    	hbinfix.getChildren().add(infix);
    	grid.add(hbinfix, 0, 0);
    	
    	Button rpn = new Button("RPN");
    	rpn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	infix.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	HBox hbrpn = new HBox(10);
    	hbrpn.setAlignment(Pos.BOTTOM_RIGHT);
    	hbrpn.getChildren().add(rpn);
    	grid.add(hbrpn, 3, 0);
    	
    	TextField display = new TextField();
    	grid.add(display, 0, 1, 4, 1);
    	
    	
    	Button digit7 = new Button("7");
    	digit7.setMinSize(50, 50);
    	HBox hbdigit7 = new HBox(10);
    	hbdigit7.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit7.getChildren().add(digit7);
    	grid.add(hbdigit7, 0, 2);
    	
    	Button digit8 = new Button("8");
    	digit8.setMinSize(50, 50);
    	HBox hbdigit8 = new HBox(10);
    	hbdigit8.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit8.getChildren().add(digit8);
    	grid.add(hbdigit8, 1, 2);
    	
    	Button digit9 = new Button("9");
    	digit9.setMinSize(50, 50);
    	HBox hbdigit9 = new HBox(10);
    	hbdigit9.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit9.getChildren().add(digit9);
    	grid.add(hbdigit9, 2, 2);
		
		Button divide = new Button("/");
    	divide.setMinSize(50, 50);
    	HBox hbdivide = new HBox(10);
    	hbdivide.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdivide.getChildren().add(divide);
    	grid.add(hbdivide, 3, 2);
    	
    	
    	Button digit4 = new Button("4");
    	digit4.setMinSize(50, 50);
    	HBox hbdigit4 = new HBox(10);
    	hbdigit4.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit4.getChildren().add(digit4);
    	grid.add(hbdigit4, 0, 3);
    	
    	Button digit5 = new Button("5");
    	digit5.setMinSize(50, 50);
    	HBox hbdigit5 = new HBox(10);
    	hbdigit5.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit5.getChildren().add(digit5);
    	grid.add(hbdigit5, 1, 3);
    	
    	Button digit6 = new Button("6");
    	digit6.setMinSize(50, 50);
    	HBox hbdigit6 = new HBox(10);
    	hbdigit6.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit6.getChildren().add(digit6);
    	grid.add(hbdigit6, 2, 3);
    	
		Button multiply = new Button("*");
    	multiply.setMinSize(50, 50);
    	HBox hbmultiply = new HBox(10);
    	hbmultiply.setAlignment(Pos.BOTTOM_RIGHT);
    	hbmultiply.getChildren().add(multiply);
    	grid.add(hbmultiply, 3, 3);
		
    	
    	Button digit1 = new Button("1");
    	digit1.setMinSize(50, 50);
    	HBox hbdigit1 = new HBox(10);
    	hbdigit1.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit1.getChildren().add(digit1);
    	grid.add(hbdigit1, 0, 4);
    	
    	Button digit2 = new Button("2");
    	digit2.setMinSize(50, 50);
    	HBox hbdigit2 = new HBox(20);
    	hbdigit2.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit2.getChildren().add(digit2);
    	grid.add(hbdigit2, 1, 4);
    	
    	Button digit3 = new Button("3");
    	digit3.setMinSize(50, 50);
    	HBox hbdigit3 = new HBox(30);
    	hbdigit3.setAlignment(Pos.BOTTOM_RIGHT);
    	hbdigit3.getChildren().add(digit3);
    	grid.add(hbdigit3, 2, 4);
		
		Button subtract = new Button("-");
    	subtract.setMinSize(50, 50);
    	HBox hbsubtract = new HBox(30);
    	hbsubtract.setAlignment(Pos.BOTTOM_RIGHT);
    	hbsubtract.getChildren().add(subtract);
    	grid.add(hbsubtract, 3, 4);
		
		
		
        primaryStage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}