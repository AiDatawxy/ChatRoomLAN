package manage;

import java.util.*;

import java.io.*;

public class Manage {
	
//===== write register information to file information.dat =====//
// and create category for each username //
	public static void addRegisterInformation(String username, 
			String password, String nickname) {
		
		File file1 = new File("users_files/" + username + "/message_records/");
		if(!file1.exists())
			file1.mkdirs();	
		
		File file2 = new File("manage_files/");
		if(!file2.exists())
			file2.mkdirs();
		
		File file3 = new File("manage_files/information.dat");	
		try {
			try(
				FileWriter writer = new FileWriter(file3,true);
				){
				writer.write(username + "\t");
				writer.write(password + "\t");
				writer.write(nickname + "\r\n");
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

//======== search register information from file information.dat ===//
	public static String[] searchInformation(String username) {
		String[] results = new String[3];
		String[] temp = new String[3];
		File file = new File("manage_files/information.dat");
		String s = new String();	
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					temp = s.split("\t");
					if(temp[0].equals(username)) {
						System.arraycopy(temp, 0, results, 0, temp.length);
						break;
					}
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return results;
	}
	
//================== Set register information to file information.dat =============//
	public static void setRegisterInformation(String username,
			String newPassword, String newNickname) {
		File file = new File("manage_files/information.dat");
		String s = new String();
		String[] ss = new String[3];
		ArrayList<String[]> temp = new ArrayList<>();
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					ss = s.split("\t");
					if(ss[0].equals(username)) {
						ss[1] = newPassword;
						ss[2] = newNickname;
					}		
					temp.add(ss);
				}
			}
			
			try(
				FileWriter clear = new FileWriter(file, false);
				FileWriter writer = new FileWriter(file,true);
				){
				clear.write("");
				clear.flush();
				for(int i = 0; i < temp.size(); i++) {
					writer.write(temp.get(i)[0] + "\t");
					writer.write(temp.get(i)[1] + "\t");
					writer.write(temp.get(i)[2] + "\r\n");
				}
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void setRegisterInformation(String username,
			String newPassword) {
		File file = new File("manage_files/information.dat");
		String s = new String();
		String[] ss = new String[3];
		ArrayList<String[]> temp = new ArrayList<>();
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					ss = s.split("\t");
					if(ss[0].equals(username)) {
						ss[1] = newPassword;
					}		
					temp.add(ss);
				}
			}
			
			try(
				FileWriter clear = new FileWriter(file, false);
				FileWriter writer = new FileWriter(file,true);
				){
				clear.write("");
				clear.flush();
				for(int i = 0; i < temp.size(); i++) {
					writer.write(temp.get(i)[0] + "\t");
					writer.write(temp.get(i)[1] + "\t");
					writer.write(temp.get(i)[2] + "\r\n");
				}
				writer.flush();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
//========= get username ArrayList from file information.dat ==========//
	public static ArrayList<String> getUsernamesArrayList(){
		ArrayList<String> usernamesArrayList = new ArrayList<String>();
		File file = new File("manage_files/information.dat");
		String s = new String();
		try {
			try(
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
				while((s = bufferedReader.readLine()) != null) {
					usernamesArrayList.add(s.split("\t")[0]);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return usernamesArrayList;
	}

	
}
