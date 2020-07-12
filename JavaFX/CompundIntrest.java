package mj223vn_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompundIntrest extends Application {
	Label theResult;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Compound Intrest");
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 380, 200, Color.WHITE);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		ColumnConstraints column1 = new ColumnConstraints(150);// Fixed for labels
		ColumnConstraints column2 = new ColumnConstraints(50, 100, 200); // minimum, pref, max.
		column2.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(column1,column2);
		
		Label lblstAmount = new Label("Start amount");
		Label lblInterest = new Label("Interest");
		Label lblNumOfYears = new Label("Number of years");
		
		TextField stAmount = new TextField();
		TextField interest = new TextField();
		TextField numOfYears = new TextField();
		
		Button calcBtn = new Button("Calculate");
		calcBtn.setOnAction(e ->{
			double amo = Double.parseDouble(stAmount.getText());
			double inter = Double.parseDouble(interest.getText());
			double years = Double.parseDouble(numOfYears.getText());
			double per = inter/100;
			double pow = Math.pow((1 + per), years);
			int result = (int)Math.round(amo * pow);
			theResult.setText("In total that will be " + Integer.toString(result));
		});
		theResult = new Label();
		
		GridPane.setHalignment(theResult, HPos.RIGHT);
		gridPane.add(theResult, 1, 4);
		
		//Amount label
		GridPane.setHalignment(lblstAmount, HPos.RIGHT);
		gridPane.add(lblstAmount, 0, 0);
		
		//Interest label
		GridPane.setHalignment(lblInterest, HPos.RIGHT);
		gridPane.add(lblInterest, 0, 1);
		
		//Number of years label
		GridPane.setHalignment(lblNumOfYears, HPos.RIGHT);
		gridPane.add(lblNumOfYears, 0, 2);
		
		//Amount textField
		GridPane.setHalignment(stAmount, HPos.LEFT);
		gridPane.add(stAmount, 1, 0);
		
		//Interest textField
		GridPane.setHalignment(interest, HPos.LEFT);
		gridPane.add(interest, 1, 1);
		
		//Number of years textField
		GridPane.setHalignment(numOfYears, HPos.LEFT);
		gridPane.add(numOfYears, 1, 2);
		
		
		//Calculate button
		GridPane.setHalignment(calcBtn, HPos.RIGHT);
		gridPane.add(calcBtn, 0,3);
		
		FlowPane header = new FlowPane();
		header.setPrefHeight(40);
		
		String background = "-fx-background-color:lightblue;"
				+"-fx-background-radius : 30%;"
				+"fx-background-inset : 5px;";
		header.setStyle(background);
		
		
		SVGPath icon = new SVGPath();
		icon.setContent("M15 2c-8.284 0-15 6.716-15 15s6.716 15 15 15c8.284 "
						+ "0 15-6.716 15-15s-6.716-15-15-15zM15 29c-6.627 "
						+ "0-12-5.373-12-12s5.373-12 12-12c6.627 "
						+"0 12 5.373 12 12s-5.373 12-12 12zM16 "
						+ "16v-4h4v-2h-4v-2h-2v2h-4v8h4v4h-4v2h4v2h2v-2h4l-"
						+ "0-8h-4zM14 16h-2v-4h2v4zM18 22h-2v-4h2v4z");
		icon.setFill(Color.rgb(10, 10, 10));
		
		//on header
		Text text = new Text(" Compound Interest");
		Font font = new Font("Serif", 30);
		text.setFont(font);
		text.setFill(Color.WHITE);
		
		header.getChildren().addAll(icon, text);
		
		root.setTop(header);
		root.setCenter(gridPane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
