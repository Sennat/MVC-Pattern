
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
