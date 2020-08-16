package mange_friends;

import java.util.ArrayList;
import java.io.*;

public class ManageFriends {

//=============== add friend name to the friends file ===========//
	public static void addFriendsName(String username, String name) {
		File file = new File("users_files/" + username + "/friends.dat");
		ManageMessageRecords.newMessageRecordsDat(username, name);
		try {
			try(
				FileWriter writer = new FileWriter(file,true);
				){
				writer.write(name + "\r\n");
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

//========= get friends names LinkedList from friends file ==========//
	public static ArrayList<String> getFriendsArrayList(String username){
		ArrayList<String> friendsArrayList = new ArrayList<String>();
		File file = new File("users_files/" + username + "/friends.dat");
		String s = new String();
		if(file.exists() && file.isFile()) {
			try {
				try(
					FileReader reader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(reader);
					){
					while((s = bufferedReader.readLine()) != null) {
						friendsArrayList.add(s);
					}
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
			
		return friendsArrayList;
	}

//============= delete one of the friend name of friends file ========//
	public static void deleteFriendsName(String username, String name) {
		File file = new File("users_files/" + username + "/friends.dat");
		ManageMessageRecords.deleteFriendMessageRecordsDat(username, name);
		String s = new String();
		ArrayList<String> temp = new ArrayList<String>();
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					if(!s.trim().equals(name)) {
						temp.add(s.trim());
					}		
				}
			}
			
			try(
				FileWriter clear = new FileWriter(file, false);
				FileWriter writer = new FileWriter(file,true);
				){
				clear.write("");
				clear.flush();
				for(int i = 0; i < temp.size(); i++) {
					writer.write(temp.get(i) + "\r\n");
				}
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	


}
