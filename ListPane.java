package panel;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import mange_friends.ManageFriends;
import javafx.scene.text.Text;

public class ListPane extends BorderPane {
	//======= Design the ListPane for Display Friends ========//
	
	protected String username = new String();
	protected TextField textField = new TextField();
	protected Button btAdd = new Button("Add");
	protected Button btDelete = new Button("Delete");
	protected  ArrayList<String> friends = new ArrayList<>();
	protected Text text = new Text();
	protected ListView<String> lv = new ListView<>();
	protected String currentFriend = "";
	
	protected ListPane(String username) {
		
		this.username = username;
		
		BorderPane paneForNodes = new BorderPane();
		VBox leftPane = new VBox();
		
		friends = ManageFriends.getFriendsArrayList(username);
		lv.setItems(FXCollections.observableArrayList(friends));
		lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		ScrollPane scrollPane = new ScrollPane(lv);
			
		paneForNodes.setLeft(btDelete);
		paneForNodes.setCenter(textField);
		paneForNodes.setRight(btAdd);
		paneForNodes.setBottom(text);
		
		leftPane.getChildren().addAll(scrollPane, paneForNodes);
		
		setLeft(leftPane);
		
		btAdd.setOnAction(e -> {
			text.setText("");
			addFriend();
		});
		
		// The Event Action Will Be ReDefined in Inherited Class
		/*
		btDelete.setOnAction( e -> {
			text.setText("");
			if(!currentFriend.isEmpty()) {
				deleteFriend(currentFriend);
			}	
		});		
		*/
		
		lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
			currentFriend = lv.getSelectionModel().
				selectedItemProperty().getValue().toString();
		});
		
	}
	
	protected void addFriend() {
		if(textField.getText().isEmpty()) {
		}
		else if(!manage.Manage.getUsernamesArrayList()
				.contains(textField.getText())) {
			text.setText("No such a user");
		}
		else if(mange_friends.ManageFriends.getFriendsArrayList(username)
				.contains(textField.getText())) {
			text.setText("The user is already your friend");
		}
		else if(textField.getText().equals(username)) {
			text.setText("You can not add yourself");
		}
		else {
			mange_friends.ManageFriends.addFriendsName(username, textField.getText());
			friends = ManageFriends.getFriendsArrayList(username);
			lv.setItems(FXCollections.observableArrayList(friends));
			text.setText("Add successfully");
		}
	}
	
	protected void deleteFriend(String currentFriend) {
		mange_friends.ManageFriends.deleteFriendsName(username, currentFriend);
		friends = ManageFriends.getFriendsArrayList(username);
		lv.setItems(FXCollections.observableArrayList(friends));
		text.setText(currentFriend + " be deleted.");
		currentFriend = "";
	}
	
	public void setUsername(String s) {
		username = s;
	}
	
	
}
