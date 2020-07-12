package mj223vn_assign3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * A simple paint program that gives the user the alternatives to print a line, dot, rectangle or circle.
 * @author marcus
 *
 */
public class TinyPainter extends Application {
	ArrayList<Double> sizeList;
	ColorPicker colorPicker = new ColorPicker(Color.BLACK);
	ComboBox<Double> sizes = new ComboBox<Double>();
	ComboBox<String> shapes = new ComboBox<String>();

	Circle circle = new Circle();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tiny Painter");
		BorderPane pane = new BorderPane();
		pane.setTop(getHBox2(pane));
		getHBox(pane);

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void getHBox(BorderPane canvas) {
		shapes.getSelectionModel().selectedIndexProperty().addListener(e -> {
			if (shapes.getValue().equals("Line")) {

				canvas.setOnMousePressed(ev -> {
					Line line = new Line();
					line.setStroke(colorPicker.getValue());
					line.setStrokeWidth(sizes.getSelectionModel().getSelectedIndex());
					line.setStartX(ev.getX());
					line.setStartY(ev.getY());
					line.setEndX(ev.getX());
					line.setEndY(ev.getY());

					canvas.setOnMouseDragged(ov -> {
						line.setEndX(ov.getX());
						line.setEndY(ov.getY());

					});
					canvas.setOnMouseReleased(av -> {
						line.setEndX(av.getX());
						line.setEndY(av.getY());

					});
					canvas.getChildren().add(line);
				});
			}
			
			else if(shapes.getValue().equals("Dot")) {
				canvas.setOnMousePressed(ev ->{
					Rectangle dot = new Rectangle();
					dot.setFill(colorPicker.getValue());
					dot.setX(ev.getX());
					dot.setY(ev.getY());
					dot.setHeight(sizes.getSelectionModel().getSelectedItem());
					dot.setWidth(sizes.getSelectionModel().getSelectedItem());
				canvas.setOnMouseDragged(ov ->{
					dot.setHeight(sizes.getSelectionModel().getSelectedItem());
					dot.setWidth(sizes.getSelectionModel().getSelectedItem());
				});
				canvas.setOnMouseReleased(av ->{
					dot.setHeight(sizes.getSelectionModel().getSelectedItem());
					dot.setWidth(sizes.getSelectionModel().getSelectedItem());
				});

					canvas.getChildren().add(dot);
				});
			}
			
			else if(shapes.getValue().equals("Rectangle")) {
				canvas.setOnMousePressed(ev -> {
					Rectangle rectangle = new Rectangle();
					rectangle.setFill(colorPicker.getValue());
					rectangle.setX(ev.getX());
					rectangle.setY(ev.getY());
				
					canvas.setOnMouseDragged(ov ->{
						rectangle.setHeight(ov.getY() -rectangle.getY());
						rectangle.setWidth(ov.getX() - rectangle.getX());
					});
					canvas.setOnMouseReleased(av ->{
						rectangle.setHeight(av.getY() -rectangle.getY());
						rectangle.setWidth(av.getX() - rectangle.getX());
					});
					
					canvas.getChildren().add(rectangle);
				});
			}
			
			else if (shapes.getValue().equals("Circle")) {
				
				canvas.setOnMousePressed(ev -> {
					circle = new Circle();
					circle.setFill(colorPicker.getValue());
					circle.setCenterX(ev.getX());
					circle.setCenterY(ev.getY());
					circle.setRadius(1);
					
					canvas.setOnMouseDragged(ov -> {
						double circleX = circle.getCenterX();
						double circleY = circle.getCenterY();
						circle.setRadius(Math.sqrt( Math.pow(ov.getX() - circleX, 2) + Math.pow(ov.getY() - circleY, 2)));
						
					});
					canvas.setOnMouseReleased(av -> {
						double circleX = circle.getCenterX();
						double circleY = circle.getCenterY();
						circle.setRadius(Math.sqrt( Math.pow(av.getX() - circleX, 2) + Math.pow(av.getY() - circleY, 2)));
					});
					canvas.getChildren().add(circle);
				});
			}
		});
	}

	public HBox getHBox2(BorderPane canvas) {
		shapes.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
		
		sizes.getItems().addAll(1.0, 5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0);
		
		colorPicker.setOnAction(e -> {
			colorPicker.getValue();
		});

		HBox hBox = new HBox();
		hBox.setSpacing(5);
		hBox.getChildren().addAll(shapes, sizes, colorPicker);

		return hBox;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
