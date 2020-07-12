package mj223vn_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Random;

public class Yathzee extends Application {
	HBox dices;
	int rolls = 3;
	Image theDice;
	Image first;
	Image second;
	Image third;
	Image fourth;
	Image fifth;
	ImageView one;
	ImageView two;
	ImageView three;
	ImageView four;
	ImageView five;
	Label score;
	ImageView[] scoreChecker = new ImageView[5];
	int[] scores = new int[5];

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("YatzyDemo");

		first = rollDice();
		second = rollDice();
		third = rollDice();
		fourth = rollDice();
		fifth = rollDice();

		one = new ImageView(first);
		two = new ImageView(second);
		three = new ImageView(third);
		four = new ImageView(fourth);
		five = new ImageView(fifth);

		one.setPreserveRatio(true);
		one.setFitHeight(50);
		two.setPreserveRatio(true);
		two.setFitHeight(50);
		three.setPreserveRatio(true);
		three.setFitHeight(50);
		four.setPreserveRatio(true);
		four.setFitHeight(50);
		five.setPreserveRatio(true);
		five.setFitHeight(50);

		VBox layout = new VBox();
		layout.setPadding(new Insets(5, 5, 5, 5));
		layout.setSpacing(10);

		Text title = new Text("Yatzy");
		title.setFont(Font.font("Verdana", 55));

		HBox theBoxes = new HBox();
		theBoxes.setSpacing(50);
		theBoxes.setPadding(new Insets(0, 25, 0, 25));
		CheckBox firstBox = new CheckBox();
		firstBox.setVisible(false);
		CheckBox secondBox = new CheckBox();
		secondBox.setVisible(false);
		CheckBox thirdBox = new CheckBox();
		thirdBox.setVisible(false);
		CheckBox fourthBox = new CheckBox();
		fourthBox.setVisible(false);
		CheckBox fifthBox = new CheckBox();
		fifthBox.setVisible(false);
		theBoxes.getChildren().addAll(firstBox, secondBox, thirdBox, fourthBox, fifthBox);

		score = new Label("Roll the dice's to start the game.");
		score.setPadding(new Insets(5, 0, 0, 5));

		HBox theButton = new HBox(20);
		Button btn = new Button("Roll the dice's");
		btn.setOnAction(e -> {
			dices.getChildren().clear();
			rolls--;
			score.setText("You have " + rolls + " roll's left" + ", Score:"+ scores[2]);
			handelAction(firstBox, secondBox, thirdBox, fourthBox, fifthBox);
		});
		theButton.getChildren().addAll(btn, score);

		dices = new HBox(15);
		dices.setPadding(new Insets(5, 10, 5, 10));

		dices.getChildren().addAll(one, two, three, four, five);

		layout.getChildren().addAll(title, dices, theBoxes, theButton);
		Scene scene = new Scene(layout, 350, 250);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private Image rollDice() {
		Random rand = new Random();

		int dice = rand.nextInt(6);
		switch (dice) {
		case 0:
			theDice = new Image("file:dices/diceOne.png");
			scores[0]++;
			break;
		case 1:
			theDice = new Image("file:dices/diceTwo.png");
			scores[1]++;
			break;
		case 2:
			theDice = new Image("file:dices/diceThree.png");
			scores[2]++;
			break;
		case 3:
			theDice = new Image("file:dices/diceFour.png");
			scores[3]++;
			break;
		case 4:
			theDice = new Image("file:dices/diceFive.png");
			scores[4]++;
			break;
		}

		return theDice;
	}

	private void handelAction(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4, CheckBox box5) {
		if (rolls == 2) {
			box1.setVisible(true);
			box2.setVisible(true);
			box3.setVisible(true);
			box4.setVisible(true);
			box5.setVisible(true);

		}

		if (rolls >= 0 && rolls < 3) {
			if (box1.isSelected())
				one = new ImageView(first);
			if (!box1.isSelected()) {
				first = rollDice();
				one = new ImageView(first);
			}
			if (box2.isSelected())
				two = new ImageView(second);
			if (!box2.isSelected()) {
				second = rollDice();
				two = new ImageView(second);
			}
			if (box3.isSelected())
				three = new ImageView(third);
			if (!box3.isSelected()) {
				third = rollDice();
				three = new ImageView(third);
			}
			if (box4.isSelected())
				four = new ImageView(fourth);
			if (!box4.isSelected()) {
				fourth = rollDice();
				four = new ImageView(fourth);
			}
			if (box5.isSelected())
				five = new ImageView(fifth);
			if (!box5.isSelected()) {
				fifth = rollDice();
				five = new ImageView(fifth);
			}

			one.setPreserveRatio(true);
			one.setFitHeight(50);
			two.setPreserveRatio(true);
			two.setFitHeight(50);
			three.setPreserveRatio(true);
			three.setFitHeight(50);
			four.setPreserveRatio(true);
			four.setFitHeight(50);
			five.setPreserveRatio(true);
			five.setFitHeight(50);
			dices.getChildren().addAll(one, two, three, four, five);

		} else {

			score.setText(theResult());

			rolls = 3;
			box1.setVisible(false);
			box2.setVisible(false);
			box3.setVisible(false);
			box4.setVisible(false);
			box5.setVisible(false);
			box1.setSelected(false);
			box2.setSelected(false);
			box3.setSelected(false);
			box4.setSelected(false);
			box5.setSelected(false);

			one.setPreserveRatio(true);
			one.setFitHeight(50);
			two.setPreserveRatio(true);
			two.setFitHeight(50);
			three.setPreserveRatio(true);
			three.setFitHeight(50);
			four.setPreserveRatio(true);
			four.setFitHeight(50);
			five.setPreserveRatio(true);
			five.setFitHeight(50);
			dices.getChildren().addAll(one, two, three, four, five);
		}

	}

	private String theResult() {
		String res = "The result!";
		return res;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
