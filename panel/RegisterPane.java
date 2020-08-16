package panel;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RegisterPane extends GridPane{
	//========== Design the RegisterPane for Registering ==========//
	
	private TextField tfUsername = new TextField();
	private TextField tfNickname = new TextField();
	private TextField tfPassword = new TextField();
	private TextField tfPasswordAgain = new TextField();
	private Button btSubmit = new Button("Submit");
	private Text text = new Text();
	private boolean allowRegister = true;
	
	public RegisterPane() {
		setAlignment(Pos.CENTER_RIGHT);
		
		add(new Label("username *"), 0, 0);
		add(tfUsername, 1, 0);
		add(new Label("nickname *"), 0, 1);
		add(tfNickname, 1, 1);
		add(new Label("password *"), 0, 2);
		add(tfPassword, 1, 2);
		add(new Label("password again *"), 0, 3);
		add(tfPasswordAgain, 1, 3);
		
		add(btSubmit, 1, 4);
		setHalignment(btSubmit, HPos.RIGHT);	
		add(text, 0, 5);
		
		btSubmit.setOnAction(e -> {
			if(allowRegister) {
				text.setText("");
				text.setText(writeRegist(tfUsername, 
						tfPassword, tfPasswordAgain, tfNickname));
			}
		});
	}
	
	
	private String writeRegist(TextField tfUsername, TextField tfPassword, 
			TextField tfPasswordAgain, TextField tfNickname) {
		String s = new String();
		ArrayList<String> usernames = manage.Manage.getUsernamesArrayList();
		if((tfUsername.getText().isEmpty()) ||
				tfPassword.getText().isEmpty() ||
				tfNickname.getText().isEmpty()) {
				s = "Incomplete";
			}
		else if(usernames.contains(tfUsername.getText()) ||
				tfUsername.getText().equals("0")) {
			s = "Registered username!";
		}
		else if(!tfPassword.getText().equals(tfPasswordAgain.getText())) {
			s = "Enter the same password!";
		}
		else {
			manage.Manage.addRegisterInformation(tfUsername.getText(),
					tfPassword.getText(), tfNickname.getText());
			s = "Successfully registered";
		}
		
		return s;
	}
	
	
	public void allowRegisterTrue() {
		allowRegister = true;
	}
	
	
	public void allowRegisterFalse() {
		allowRegister = false;
	}
	
}
