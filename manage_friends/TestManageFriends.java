package mange_friends;

import java.util.ArrayList;

public class TestManageFriends {
	//====== Test Functions in Class mange_friends.ManageFriend====//
	//====== and Class mange_friends.ManageMessageRecords =========//
	
	public static void main(String[] args) {
				
		/*
		// add friends names to friends file
		// and print them. At the same time
		// create message records file for each friend
		ManageFriends.addFriendsName("wxy1", "wxy2");
		ManageFriends.addFriendsName("wxy1", "wxy3"); 
		ManageFriends.addFriendsName("wxy2", "wxy1");
		ManageFriends.addFriendsName("wxy3", "wxy2");
		
		ArrayList<String> friends = new ArrayList<String>();
		friends = ManageFriends.getFriendsArrayList("wxy1");
		for(int i = 0; i < friends.size(); i++)
			System.out.println(friends.get(i));
		*/
		
		/*
		// delete one friend and print friends again
		ManageFriends.deleteFriendsName("wxy1", "wxy9");
		ArrayList<String> friends = new ArrayList<String>();
		friends = ManageFriends.getFriendsArrayList("wxy1");		
		for(int i = 0; i < friends.size(); i++)
			System.out.println(friends.get(i));
		*/
		
		/*
		// add message records examples 
		//ManageFriends.addFriendsName("wxy1", "wxy4"); 
		ManageMessageRecords.addMessageRecord("My first name is Tiago", "wxy1", "wxy3");
		ManageMessageRecords.addMessageRecord( "My last name is Messi","wxy1", "wxy3");
		ManageMessageRecords.addMessageRecord("I am Lionel Messi's son","wxy1", "wxy3");
		ManageMessageRecords.addMessageRecord(
				"I am Lionel Mateao and Ciro's brother", "wxy1", "wxy3");
		ManageMessageRecords.addMessageRecord("I am Lionel Messi.", "wxy1", "wxy5");
		//*/
		
		
		/*
		// search message records in all friends files
		ArrayList<String[]> records = new ArrayList<>();
		records = ManageMessageRecords.searchMessageRecords("Messi", "wxy1");	
		for(int i = 0; i < records.size(); i++)
			System.out.println(records.get(i)[0] + records.get(i)[1] + records.get(i)[2]);
		*/
		
		/*
		// search message records in certain friend file
		ArrayList<String[]> records = new ArrayList<>();
		records = ManageMessageRecords.search(" Messi", "wxy1", "wxy3");	
		for(int i = 0; i < records.size(); i++)
			System.out.println(records.get(i)[0] + records.get(i)[1] + records.get(i)[2]);		
		*/
		
		
		/*
		// delete certain message in certain friend file
		ManageMessageRecords.deleteMessageRecords(4, "wxy1", "wxy3");
		*/		
		
	}
	
}
