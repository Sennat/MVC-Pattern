/* ************************************************************************************
 * Copyright (C) Nov 24, 2017, Natnael Alemayehu, All rights Reserved. Unauthorized 
 * copying of this file and/or distributed without, the express permission of 
 * Natnael Alemayehu is strictly prohibited. Written by Natnael Alemayehu 1:35:18 AM.
 * ************************************************************************************
 */

package mvc;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A Controller class implemented to demonstrate MVC Design Pattern 
 * that a controller acts on both model and view. It controls the 
 * data flow into model object and updates the view whenever data 
 * changes. It keeps view and model separate.
 *
 */
public class Controller extends Application {
	
	//Filed
	static View gui;
	
	/**
	 * A main method to run the application
	 * @param args
	 */
	public static void main(String[] args) {
	 gui = new View();
		launch(args);
	}

	/**
	 * A method to run a GUI
	 */
	public void start(Stage stage) throws Exception {
		gui.start(stage);
		
	}
	
	

}
