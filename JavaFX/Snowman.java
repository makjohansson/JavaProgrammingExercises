package mj223vn_assign2;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Snowman extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Snowman");
		
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.rgb(87,216,242));
		
		//Snowman
		Circle bigPart = new Circle(400, 350, 60);
		bigPart.setFill(Color.WHITE);
		Circle middlePart = new Circle(400, 265, 40);
		middlePart.setFill(Color.WHITE);
		Circle head = new Circle(400, 205, 30);
		head.setFill(Color.WHITE);
		root.getChildren().addAll(bigPart, middlePart, head);
		
		//Face
		Circle eye1 = new Circle(390, 200, 6);
		eye1.setFill(Color.BLACK);
		Circle eye2 = new Circle(410, 200, 6);
		eye2.setFill(Color.BLACK);
		QuadCurve smile = new QuadCurve(390, 215, 400, 230, 410, 215);
		smile.setFill(Color.BLACK);
		root.getChildren().addAll(eye1, eye2, smile);
		
		//Hat
		Rectangle lowerPart = new Rectangle(80, 10);
		lowerPart.setFill(Color.BLACK);
		lowerPart.setX(360);
		lowerPart.setY(180);
		Rectangle top = new Rectangle(60, 50);
		top.setX(370);
		top.setY(130);
		root.getChildren().addAll(lowerPart, top);
		
		//buttons
		Circle topB = new Circle(400, 245, 5);
		topB.setFill(Color.BLACK);
		Circle middleB = new Circle(400, 265, 5);
		topB.setFill(Color.BLACK);
		Circle lowB = new Circle(400, 285, 5);
		topB.setFill(Color.BLACK);
		root.getChildren().addAll(topB, middleB, lowB);
		
		//Sun
		Circle sun = new Circle(700, 100, 70);
		sun.setFill(Color.YELLOW);
		root.getChildren().add(sun);
		
		
		
		//Snow
		Rectangle snow = new Rectangle(0, 400, 800, 600);
		snow.setFill(Color.WHITE);
		root.getChildren().add(snow);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
