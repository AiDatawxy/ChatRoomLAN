package panel;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SetPane extends GridPane {
	//=========== Design the SetPane for Setting ==========//
	
	private TextField tfUsername = new TextField();
	private TextField tfPassword = new TextField();
	private TextField tfNewNickname = new TextField();
	private TextField tfNewPassword = new TextField();
	private TextField tfNewPasswordAgain = new TextField();
	private Button btSubmit = new Button("Submit");
	private Text text = new Text();
	private boolean allowSet = true;
	
	public SetPane() {
		setAlignment(Pos.CENTER_RIGHT);
		
		add(new Label("username *"), 0, 0);
		add(tfUsername, 1, 0);
		add(new Label("password *"), 0, 1);
		add(tfPassword, 1, 1);
		add(new Label("new nickname"), 0, 2);
		add(tfNewNickname, 1, 2);
		add(new Label("new password"), 0, 3);
		add(tfNewPassword, 1, 3);
		add(new Label("new password again"), 0, 4);
		add(tfNewPasswordAgain, 1, 4);
		
		add(btSubmit, 1, 5);
		setHalignment(btSubmit, HPos.RIGHT);
		add(text, 0, 6);
		
		btSubmit.setOnAction(e -> {
			if(allowSet) {
				text.setText("");
				text.setText(changeSet(tfUsername, 
						tfPassword, tfNewNickname, tfNewPassword,
						tfNewPasswordAgain));
			}		
		});
	}
	
	
	private String changeSet(TextField tfUsername, 
			TextField tfPassword,TextField tfNewNickname, 
			TextField tfNewPassword, TextField tfNewPasswordAgain) {
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
		else if((tfNewNickname.getText().isEmpty()) &&
					(tfNewPassword.getText().isEmpty())) {
			s = "Set at least one object!";
		}
		else if(tfNewPassword.getText().isEmpty()) {
			manage.Manage.setRegisterInformation(tfUsername.getText(), 
					tfPassword.getText(), tfNewNickname.getText());
			s = "Set new nickname successfully";
		}
		else if(tfNewNickname.getText().isEmpty()) {
			if(!tfNewPassword.getText().equals(tfNewPasswordAgain.getText())) {
				s = "Enter the same new password!";
			}
			else {
				manage.Manage.setRegisterInformation(tfUsername.getText(), 
						tfNewPassword.getText());
				s = "Set new password successfully";
			}
		}
		else {
			if(!tfNewPassword.getText().equals(tfNewPasswordAgain.getText())) {
				s = "Enter the same new password!";
			}
			else {
				manage.Manage.setRegisterInformation(tfUsername.getText(), 
						tfNewPassword.getText(), tfNewNickname.getText());
				s = "Set new nickename and new password successfully";
			}
		}
		
	
		return s;
	}
	
	
	public void allowSetTrue() {
		allowSet = true;
	}
	
	public void allowSetFalse() {
		allowSet = false;
	}
		
}
