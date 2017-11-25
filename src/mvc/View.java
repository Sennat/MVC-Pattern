/* ************************************************************************************
 * Copyright (C) Nov 24, 2017, Natnael Alemayehu, All rights Reserved. Unauthorized 
 * copying of this file and/or distributed without, the express permission of 
 * Natnael Alemayehu is strictly prohibited. Written by Natnael Alemayehu 2:05:22 AM.
 * ************************************************************************************
 */

package mvc;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A View class implemented to demonstrate MVC Design Pattern a view 
 * representation of the visualization of the data that model contains.
 * @author Natnael Alemayehu
 *
 */
public class View extends Application implements EventHandler<ActionEvent>{

	//Fields
	private Stage stage;
	private Scene scene;
	private GridPane gridPane;
	private Label studentId, numberOfCourses, total;
	private RadioButton residentradio, overSearadio;
	private TextField inputId, inputNumCourse;
	private Button calcButton, resetButton;
	private Text header, amount, flag;
	private VBox hBox;

	/**
	 * A method to start the GUI
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Student Tution Calculator");
		gridPane = new GridPane();
		gridPane.setPrefSize(500, 400);
		gridPane.setAlignment(Pos.BASELINE_LEFT);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		gridPane.setHgap(25);
		gridPane.setVgap(15);

		header = new Text("State Community Collage Tution Fees Calculator");
		header.setStyle("-fx-font: normal 24px 'serif'; -fx-text-fill: #625D5D; -fx-text-alignment: center;");

		studentId = new Label("Student ID: ");
		studentId.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill: #000; -fx-text-alignment: center;");

		inputId = new TextField();
		inputId.setStyle("-fx-border-radius: 5; -fx-pref-width: 135px; -fx-pref-height: 28px; -fx-border-color: #000; -fx-font-size: 14px; -fx-text-fill: #000;");

		residentradio = new RadioButton("Resident");
		residentradio.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill: #000; -fx-text-alignment: center;");

		overSearadio = new RadioButton("International");
		overSearadio.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill: #000; -fx-text-alignment: center;");

		numberOfCourses = new Label("#s of Courses: ");
		numberOfCourses.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill: #000; -fx-text-alignment: center;");

		inputNumCourse = new TextField("0");
		inputNumCourse.setStyle("-fx-border-radius: 5;-fx-pref-width: 135px; -fx-pref-height: 28px; -fx-border-color: #000; -fx-font-size: 14px; -fx-text-fill: #000;");

		total = new Label("Total amount: ");
		total.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill: #000; -fx-text-alignment: center;");

		amount = new Text();
		amount.setStyle("-fx-background-color: transparent; -fx-font: normal 18px 'serif'; -fx-font-size: 20px; -fx-text-fill: #00FF00;");

		calcButton = new Button("Calculate");
		calcButton.setStyle("-fx-border-radius: 5;-fx-pref-width: 110px; -fx-pref-height: 30px; -fx-border-color: #000; -fx-font-size: 18px; -fx-text-fill: #000;");
		resetButton = new Button("Reset");
		resetButton.setStyle("-fx-border-radius: 5; -fx-pref-width: 110px; -fx-pref-height: 30px; -fx-border-color: #000; -fx-font-size: 18px; -fx-text-fill: #000;");
		flag = new Text();

		GridPane.setConstraints(studentId, 0, 1);
		GridPane.setConstraints(inputId, 1, 1);
		GridPane.setConstraints(residentradio, 0, 2);
		GridPane.setConstraints(overSearadio, 1, 2);
		GridPane.setConstraints(numberOfCourses, 0, 3);
		GridPane.setConstraints(inputNumCourse, 1, 3);;
		GridPane.setConstraints(total, 0, 4);
		GridPane.setConstraints(amount, 1, 4);
		GridPane.setConstraints(calcButton, 0, 5);
		GridPane.setConstraints(resetButton, 1, 5);

		gridPane.getChildren().addAll(studentId, inputId, residentradio, overSearadio, 
				numberOfCourses, inputNumCourse, total, amount, calcButton, resetButton);

		//Add buttons to the action listener
		calcButton.setOnAction(this);
		resetButton.setOnAction(this);

		//A horizontal box to holds the header, the error info and a Gridpane
		hBox = new VBox();
		hBox.setStyle("-fx-width: 200px;-fx-background-color: #F9F9FA; -fx-border-color: #2e8b57; -fx-background-insets: 5.0 5.0 5.0 5.0; -fx-border-width: 2px; -fx-border-radius: 5;");
		hBox.setSpacing(2);
		hBox.setMargin(header, new Insets(40, 0, 10, 70));
		hBox.setMargin(flag, new Insets(5, 0, 0, 70));
		hBox.setMargin(gridPane, new Insets(5, 0, 20, 50));
		ObservableList list1 = hBox.getChildren();
		hBox.getChildren().addAll(header, flag, gridPane);

		//Add scene into stage
		scene = new Scene(hBox, 600, 400);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if((event.getSource() == calcButton) && (studentId.getText() != null) && (!studentId.getText().isEmpty()) && (!inputId.getText().isEmpty())) {
			flag.setText(" ");
			DecimalFormat Deciformat = new DecimalFormat("$###,##0.00");
			String id = inputId.getText();
			int numCourses = Integer.parseInt(inputNumCourse.getText());
			boolean home = residentradio.isSelected();
			if(residentradio.isSelected()) {
				overSearadio.setSelected(false);
			}
			Model fees = new Model(id, numCourses, home);
			double amountDue = fees.calculateFees();
			amount.setText(Deciformat.format(amountDue));
			
		}else if((event.getSource() == calcButton) && (inputId.getText().isEmpty())) {
			flag.setText(" ");
			flag.setText("Error: enter student id");
			flag.setStyle("-fx-font: normal 14px 'serif'; -fx-text-fill: #FF0000;");
		}
		
		if((event.getSource() == resetButton)) {
			inputId.clear();
			residentradio.setSelected(false);
			overSearadio.setSelected(false);
			inputNumCourse.clear();
			amount.setText(" ");
			flag.setText(" ");
		}

	}

}
