package panel;

import javafx.scene.layout.StackPane;

public class ChatWe extends LoginPane {
		//===== This ChatWe Is the Main Pane =====================//
		//===== This ChatWe Inherit From LoginPane ===============//
	
		public ChatWe() {
			
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
						
						ChatPane chatPane = new ChatPane(s);
						SearchPane searchPane = new SearchPane(s);
						setCenter(chatPane);
						setTop(searchPane);
					}		
				}		
			});
			
			btQuit.setOnAction(e -> {
				text.setText("");
				allowLogin = true;
				registerPane.allowRegisterTrue();
				setPane.allowSetTrue();
				loginUsername = "0";
				
				setCenter(new StackPane());
				setTop(new StackPane());
			});
			
		}
	
}
