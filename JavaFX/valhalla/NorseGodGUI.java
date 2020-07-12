package mj223vn_assign3.valhalla;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * A javafx program to give the user information about a handpicked number of gods
 * @author marcus
 *
 */
public class NorseGodGUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(5,10,5,5));
		Text text = new Text( "Norse Gods and other Beings");
		text.setFont(Font.font("Serif",FontWeight.BOLD, 30));
		
		ListView<String> godsName = new ListView<>();
		godsName.setPrefWidth(150);
		ScrollPane scroll = new ScrollPane();
		scroll.setContent(godsName);

		godsName.getItems().addAll("Odin", "Thor", "Loki", "Baldur", "Freyr", "Freya", "Heimdll", "Bragi", "Tyr");
		
		Image frontImage = new Image("file:GodInfo/norse-god-icons.png");
		ImageView showFrontImage = new ImageView(frontImage);
		showFrontImage.setFitWidth(400);
		showFrontImage.setPreserveRatio(true);
		
		Label theText = new Label();
		theText.setWrapText(true);
		theText.setStyle("-fx-background-color: white");
		
		
		final ArrayList<NorseGod> listOfGods = new ArrayList<>();
		listOfGods.add(new NorseGod("Odin", "Aeisr", fileReader("GodInfo/odin.txt")));
		listOfGods.add(new NorseGod("Thor", "Aeisr", fileReader("GodInfo/thor.txt")));
		listOfGods.add(new NorseGod("Loki", "Aeisr", fileReader("GodInfo/loki.txt")));
		listOfGods.add(new NorseGod("Baldur", "Aeisr", fileReader("GodInfo/baldr.txt")));
		listOfGods.add(new NorseGod("Freyr", "Vanir", fileReader("GodInfo/freyr.txt")));
		listOfGods.add(new NorseGod("Freya", "Vanir", fileReader("GodInfo/freyja.txt")));
		listOfGods.add(new NorseGod("Heimdll", "Aeisr", fileReader("GodInfo/heimdallr.txt")));
		listOfGods.add(new NorseGod("Bragi", "Aeisr", fileReader("GodInfo/bragi.txt")));
		listOfGods.add(new NorseGod("Tyr", "Aeisr", fileReader("GodInfo/tyr.txt")));
		godsName.getSelectionModel().selectedIndexProperty().addListener(ov -> {
			theText.setText(listOfGods.get(godsName.getSelectionModel().getSelectedIndex()).getName() + "\n" + 
					listOfGods.get(godsName.getSelectionModel().getSelectedIndex()).getRace() + "\n\n" + 
					listOfGods.get(godsName.getSelectionModel().getSelectedIndex()).getDesc());
			ScrollPane scroll1 = new ScrollPane();
			scroll1.setContent(theText);
			scroll1.setFitToWidth(true);
			layout.setCenter(scroll1);
			theText.setBorder(new Border((new BorderStroke(Color.BLACK, 
		            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
			BorderPane.setMargin(layout.getCenter(), new Insets(5,5,5,5));
			
		});
		
		
		layout.setLeft(scroll);
		layout.setCenter(showFrontImage);
		layout.setTop(text);
		
		
		Scene scene = new Scene(layout);
		
		primaryStage.setTitle("Norse Gods");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private String fileReader(String file) {
		File theFile = new File(file);
		StringBuilder sbText = new StringBuilder();
		String text;
		
		try(Scanner in = new Scanner(theFile)){
			while(in.hasNext()) {
				text = in.nextLine();
				sbText.append(text);
			}
		}
		catch(IOException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error reading file!");
			alert.setHeaderText("The fil could not be read!");
			alert.setContentText("Check if file is in correct path.");
			alert.showAndWait();
		}
		return sbText.toString();
	}

}
