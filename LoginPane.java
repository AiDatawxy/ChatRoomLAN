package panel;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class LoginPane extends BorderPane {
	// ===== Design the Foundation Pane LoginPane for Login  =========//
	// ===== This LoginPane Use RegisterPane and SetPane ===== ======//
	
	protected TextField tfUsername = new TextField();
	protected TextField tfPassword = new TextField();
	protected Button btLogin = new Button("Login");
	protected Button btQuit = new Button("Quit");
	protected Text text = new Text();
	protected boolean allowLogin = true;
	protected String loginUsername = new String();
	
	protected RegisterPane registerPane = new RegisterPane();
	protected SetPane setPane = new SetPane();
	
	public LoginPane() {
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER_RIGHT);
		pane.add(new Label("username *"), 0, 0);
		pane.add(tfUsername, 1, 0);
		pane.add(new Label("password *"), 0, 1);
		pane.add(tfPassword, 1, 1);	
		pane.add(btQuit, 0, 2);
		GridPane.setHalignment(btQuit, HPos.LEFT);
		pane.add(btLogin, 1, 2);
		GridPane.setHalignment(btLogin, HPos.RIGHT);
		pane.add(text, 0, 3);
		
		Label paneLabel = new Label("Login", pane);
		Label registerPaneLabel = new Label("Register", registerPane);
		Label setPaneLabel = new Label("Set", setPane);
		
		paneLabel.setContentDisplay(ContentDisplay.BOTTOM);
		registerPaneLabel.setContentDisplay(ContentDisplay.BOTTOM);
		setPaneLabel.setContentDisplay(ContentDisplay.BOTTOM);
		
		VBox vBox = new VBox();
		vBox.getChildren().add(paneLabel);
		vBox.getChildren().add(registerPaneLabel);
		vBox.getChildren().add(setPaneLabel);
		
		setRight(vBox);
		
		// The Event Action Will Be ReDefined in Inherited Class
		/* 
		btLogin.setOnAction(e -> {
			if(allowLogin) {
				text.setText("");
				String s = new String();
				s = isMatched(tfUsername, tfPassword);
				text.setText(s);
				if(s.equals(tfUsername.getText())) {
					allowLogin = false;
					registerPane.allowRegisterFalse();
					setPane.allowSetFalse();
					loginUsername = s;
				}		
			}		
		});
		*/
		
		// The Event Action Will Be ReDefined in Inherited Class
		/*
		btQuit.setOnAction(e -> {
			text.setText("");
			allowLogin = true;
			registerPane.allowRegisterTrue();
			setPane.allowSetTrue();
			loginUsername = "0";
		});
		*/
	}
	
	protected String isMatched(TextField tfUsername,
			TextField tfPassword) {
		String s = new String();
		ArrayList<String> usernames = manage.Manage.getUsernamesArrayList();
		if((tfUsername.getText().isEmpty()) ||
			tfPassword.getText().isEmpty()) {
			s = "Incomplete";
		}
		else if(!usernames.contains(tfUsername.getText())) {
			s = "No such username!";
		}
		else if(
				!manage.Manage.searchInformation(tfUsername.getText())[1]
						.equals(tfPassword.getText())) {
			s = "Wrong password!";
		}
		else {
			 s = tfUsername.getText();
		}
		
		return s;
	}
	
	
	public String loginUsername() {
		return loginUsername;
	}
	
}
