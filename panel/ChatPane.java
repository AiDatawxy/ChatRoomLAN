package panel;

import java.util.Map;
import java.util.HashMap;
import javafx.scene.layout.StackPane;

public class ChatPane extends ListPane {
	//===== Design the ChatPane for Chat Panel, Including Friends List //
	//===== and Chat Message Area.  ================================== //
	//===== This ChatPane Inherit From ListPane =======================//
	//===== This ChatPane Use ChatTextAreaPane  =======================//
	
	private Map<String, ChatTextAreaPane> hashMap = new HashMap<>();
	private StackPane stackPane = new StackPane();
	
	public ChatPane(String username) {
		super(username);
		
		lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
			if(!hashMap.containsKey(currentFriend)) {
				hashMap.put(currentFriend, 
						new ChatTextAreaPane(username, currentFriend));
			}
			stackPane.getChildren().clear();
			stackPane.getChildren().add(hashMap.get(currentFriend));
		});
		
		btDelete.setOnAction( e -> {
			text.setText("");
			if(!currentFriend.isEmpty()) {
				hashMap.remove(currentFriend);
				stackPane.getChildren().clear();	
				deleteFriend(currentFriend);
			}
		});		
		
		setCenter(stackPane);
		
	}
}
