package texts;


import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class TextInput extends Application {
	
	//UI elements
	private Parent root;
	private TextField translation;
	private Button confirm;
	private Button changeTranslationDirection;
	private Button workOut;
	private Button saveDictionary;
	private Button add;
	private Button dictionary;
	private Label text;
	private Label german;
	private Label english;
	private Label translateTheWord;
	private Label word;
	private Label fromGermanToEnglish;
	private Label output;

	
	//model
	private TextInput store;

	@Override
	public void init() throws Exception {
		//init dao
		Parameters params = getParameters();
		List<String> paramList = params.getRaw();
		if (paramList.size()<1) {
			throw new IOException("");
		}
		
		//init input field for texts
		translation = new TextField();
		translation.setPrefWidth(300);
		translation.setPromptText("Translation");
		
		//init output buttons
		workOut = new Button("Trainieren");
		workOut.setPrefWidth(100);
		
		//init input buttons
		dictionary = new Button("Wörterbuch");
		dictionary.setPrefWidth(100);
		
		
		//init buttons
		confirm = new Button("Bestätigen");
		confirm.setOnAction(event -> {
			String input = translation.getText().trim();
			
			
		});
		
	}
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.showAndWait()
	      .filter(response -> response == ButtonType.OK)
	      .ifPresent(response -> alert.close());
	}

	@Override
	public void start(Stage primaryStage) {	
			primaryStage.setTitle("Vowel");
			Scene scene = new Scene(root,800,100);		
			primaryStage.setScene(scene);
			primaryStage.show();	
	}
	private Parent createSceneGraph() {
		
		BorderPane pane = new BorderPane();
		FlowPane inputPanel = new FlowPane();
		inputPanel.getChildren().addAll(translateTheWord, word, fromGermanToEnglish, translation, confirm, changeTranslationDirection);
		
		FlowPane outputPanel = new FlowPane();
		outputPanel.getChildren().addAll();
		
		pane.setTop(inputPanel);
		pane.setTop(workOut);
		pane.setTop(dictionary);
		pane.setCenter(confirm);
		pane.setBottom(output);
		pane.setBottom(changeTranslationDirection);
		pane.setCenter(word);
		
		
		return pane;
	}
	public static void main(String[] args) {
		launch(args);
	}
}