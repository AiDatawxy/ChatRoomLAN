package panel;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChatTextAreaPane extends VBox {
	//===== Design the ChatTextAreaPane for Chat Message Area ====//
	
	private TextArea taChat = new TextArea();
	private TextArea taSend = new TextArea();
	private Button btSend = new Button("Send");
	private String message = new String();
	private String currentMessage = new String();
	private String username = new String();
	private String name = new String();
	
	public ChatTextAreaPane(String username, String name) {
		this.username = username;
		this.name = name;
		
		taChat.setPrefColumnCount(45);
		taChat.setPrefRowCount(30);
		taChat.setWrapText(true);
		taChat.setEditable(false);
		ScrollPane taChatScrollPane = new ScrollPane(taChat);
		
		taSend.setPrefColumnCount(45);
		taSend.setPrefRowCount(10);
		taSend.setWrapText(true);
		taSend.setEditable(true);
		ScrollPane taSendScrollPane = new ScrollPane(taSend);
		
		Label label = new Label(name);
		getChildren().addAll(label, taChatScrollPane, taSendScrollPane, btSend);
		
		
		btSend.setOnAction(e -> {
			if(!taSend.getText().isEmpty()) {
				currentMessage = taSend.getText();
				mange_friends.ManageMessageRecords.addMessageRecord(
						currentMessage, username, name);
				printLocolMessage();	
			}
		});
		
	}
	
	public void printLocolMessage() {
		taChat.setStyle("-fx-text-fill: black");
		message += taSend.getText() + "\r\n";
		taChat.setText(message);
		taSend.clear();
	}
	
	public void printFriendMessage(String s) {
		taChat.setStyle("-fx-text-fill: red");
		message += s + "\r\n";
		taChat.setText(message);
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String[] sendInformation() {
		String[] information = new String[3];
		information[0] = currentMessage;
		information[1] = username;
		information[2] = name;
		
		return information;
	}
	
}
