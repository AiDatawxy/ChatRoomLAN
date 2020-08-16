package mange_friends;

import java.io.*;
import java.util.*;

public class ManageMessageRecords {

//=========== create message records files for certain friend =======//
	public static void newMessageRecordsDat(String username, String name) {
		try {
			try(
				BufferedOutputStream friendsOut = 
				new BufferedOutputStream(new FileOutputStream(
					"users_files/" + username + "/message_records/" + name + ".dat"));
				){			
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
			}
	}

//============ delete massage records file for the friend deleted ====//
	public static void deleteFriendMessageRecordsDat(String username, String name) {
		File file = new File("users_files/" + username 
				+ "/message_records/" + name + ".dat");
		if(file.exists() && file.isFile()) {
			file.delete();
		}
	}
	
//============= add friend's message records to his/her file ===========//
	public static void addMessageRecord(String strings, String username, String name) {
		File file = new File("users_files/" 
				+ username + "/message_records/" + name + ".dat");
		if(file.exists() && file.isFile()) {
			try {
				try(
					FileWriter writer = new FileWriter(file,true);	
					){
					writer.write(strings + "\r\n");
					writer.flush();
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
//=========== search message records in certain friend's file ============//
	public static ArrayList<String[]> search(String strings, String username, String name) {
		ArrayList<String[]> results = new ArrayList<>();
		Integer row = new Integer(0);
		File file = new File("users_files/" + username + "/message_records/" + name + ".dat");
		String s = new String();	
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					row++;
					String[] stemp = {"", "", ""};
					if(s.toLowerCase().contains(
							strings.toLowerCase().trim())) {
						stemp[0] += name;
						stemp[1] += row;
						stemp[2] += s;
						results.add(stemp);
					}
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return results;
		
	}

	
	public static ArrayList<String[]> searchMessageRecords(
			String strings, String username, String name){
		ArrayList<String[]> results = new ArrayList<>();
		results = search(strings, username, name);
		return results;
	}
	
	
	public static ArrayList<String[]> searchMessageRecords(String strings, String username){
		ArrayList<String[]> results = new ArrayList<>();
		ArrayList<String> friendsName = new ArrayList<>();
		friendsName = ManageFriends.getFriendsArrayList(username);
		for(String name: friendsName) {
			ArrayList<String[]> temp = search(strings, username, name);
			 for(String[] tem: temp) {
				 results.add(tem);
			 }
		}
		
		return results;
	}
	
//========= delete certain message records in certain friend file =========//
	public static void deleteMessageRecords(Integer row, String username, String name) {
		File file = new File("users_files/" + username + "/message_records/" + name + ".dat");
		Integer targetRow = new Integer(0);
		String s = new String();
		ArrayList<String> temp = new ArrayList<>();
		//ListIterator<String> tempListIterator = temp.listIterator();
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					targetRow += 1;
					if(!targetRow.equals(row)) {
						temp.add(s);
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
				//while(tempListIterator.hasNext()) {
				//	writer.write(tempListIterator.next() + "\r\n");
				//}
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
