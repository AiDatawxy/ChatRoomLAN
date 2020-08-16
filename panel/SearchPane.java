package panel;

import mange_friends.*;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SearchPane extends HBox {
	//======= Design the SearchPane for Search Message Records =======//
	
	private String username = new String();
	private TextField tfString = new TextField();
	private TextField tfFriend = new TextField();
	private Button btSearch = new Button("Search");
	private Button btClear = new Button("Clear");
	private TextArea taSearchResult = new TextArea();
	
	public SearchPane(String username) {
		
		this.username = username;
		
		GridPane pane = new GridPane();
		pane.add(new Label("String"), 0, 0);
		pane.add(tfString, 1, 0);
		pane.add(new Label("Friend"), 0, 1);
		pane.add(tfFriend, 1, 1);
		pane.add(btClear, 0, 2);
		GridPane.setHalignment(btClear, HPos.LEFT);
		pane.add(btSearch, 1, 2);
		GridPane.setHalignment(btSearch, HPos.RIGHT);
		
		taSearchResult.setPrefColumnCount(30);
		taSearchResult.setPrefRowCount(3);
		taSearchResult.setWrapText(true);
		taSearchResult.setEditable(false);
		ScrollPane scrollPane = new ScrollPane(taSearchResult);
		
		getChildren().addAll(pane, scrollPane);
		
		btClear.setOnAction(e -> {
			tfString.clear();
			tfFriend.clear();
		});
		btSearch.setOnAction(e -> {
			search(tfString, tfFriend);
		});
		
	
	}
	
	private void search(TextField tfString, TextField tfFriend) {
		String s = "";
		ArrayList<String[]> records = new ArrayList<>();
		if(tfString.getText().isEmpty()) {
		}
		else if(tfFriend.getText().isEmpty()) {
			records = ManageMessageRecords.searchMessageRecords(
					tfString.getText(), username);
		}
		else if(ManageFriends.getFriendsArrayList(username)
				.contains(tfFriend.getText())) {
			records = ManageMessageRecords.searchMessageRecords(
					tfString.getText(), username, tfFriend.getText());
		}
		else {
			records.add(new String[] {"Wrong friend name", "", ""});
		}
			
		for(int i = 0; i < records.size(); i++)
			s += records.get(i)[0] + " " + records.get(i)[1] + ": " 
					+ records.get(i)[2] + "\r\n";
		
		taSearchResult.setText(s);
	}
	
	
	public void setUsername(String s) {
		username = s;
	}
	
}
