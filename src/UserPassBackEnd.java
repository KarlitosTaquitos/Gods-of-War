import java.io.*;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserPassBackEnd {

	public static void loadUserPassFile() {
		FileReader reader;
		
		try {
			reader = new FileReader("src/UserPass.txt");
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void register(JTextField username_t, JPasswordField password_t) {
		BufferedReader bufferedReader;
		BufferedWriter bufferedWriter;
		
		String line;
		String username;
		String password;
		
		char[] passwordarray;
		String[] tokens;
		
		boolean userExists;
		
		//Opens UserPass.txt--------------------------------------------------------
		try {
			bufferedReader = new BufferedReader(new FileReader("src/UserPass.txt"));
			
			username = username_t.getText();
			passwordarray = password_t.getPassword();
			
			//checks if username field is empty
			if (username.equals("")) {
				System.out.println("Username cannot be empty.");
				
				bufferedReader.close();
				
				return;
			}
			
			userExists = false;
			
			//searches UserPass.txt for matching username------
			while((line = bufferedReader.readLine()) != null) {
				tokens = line.split(" ");
				
				if (tokens[0].equals(username)) {
					userExists = true;
					
					break;
				}
			}
			
			//checks if given username is already taken---------------------------------
			if (userExists) {
				System.out.println("Username exists. Please use a different username.");
				
				bufferedReader.close();
				
				return;
			}
			
			bufferedWriter = new BufferedWriter(new FileWriter("src/UserPass.txt", true));
			password = "";
			
			for (int i = 0; i < passwordarray.length; i++)
			{
				password += passwordarray[i];
			}
			
			//prints valid username and password in UserPass.txt---
			bufferedWriter.write("\n" + username + " " + password);
			
			System.out.println("User created!");
			
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

	public static boolean login(JTextField username_t, JPasswordField password_t) {
		BufferedReader bufferedReader;
		
		String line;
		String username;
		String password;
		
		char[] passwordarray;
		String[] tokens;
		
		//Opens UserPass.txt--------------------------------------------------------
		try {
			bufferedReader = new BufferedReader(new FileReader("src/UserPass.txt"));
			
			username = username_t.getText();
			passwordarray = password_t.getPassword();
			
			password = "";
			
			for (int i = 0; i < passwordarray.length; i++)
			{
				password += passwordarray[i];
			}
			
			//searches UserPass.txt for matching username and password---------
			while((line = bufferedReader.readLine()) != null) {
				tokens = line.split(" ");
				
				//if correct username and password, function returns true
				if (tokens[0].equals(username) && tokens[1].equals(password)) {
					
					bufferedReader.close();
					
					System.out.println("Login Successful!");
					
					return true;
				}
				
				//else incorrect credentials, returns false-----------------------------------------------
				else {
					bufferedReader.close();
					
					System.out.println("Login Unsuccessful. Please enter a valid username and password.");
					
					return false;
				}
			}
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
}
