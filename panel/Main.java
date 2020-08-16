package panel;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	//============== The Main Class to Show the Result  ===========//
	
	@Override
	public void start(Stage primaryStage) {		
		
		ChatWe pane = new ChatWe();
		Scene scene = new Scene(pane, 1500, 700);
		
		primaryStage.setTitle("ChatWe");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
