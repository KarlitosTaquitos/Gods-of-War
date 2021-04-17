import java.io.*;

//import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserPassBackEnd {

	//function that loads UserPass.txt
	public static void loadUserPassFile() {
		FileReader reader;
		
		try {
			reader = new FileReader("src/UserPass.txt");
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//register function
	@SuppressWarnings("unused")
	public static boolean register(JTextField username_t, JPasswordField password_t, JTextArea warning_l) {
		BufferedReader bufferedReader;
		BufferedWriter bufferedWriter;
		
		String line;
		String username;
		String password;
		String encryptedUsername;
		String encryptedPassword;
		
		char[] passwordArray;
		String[] tokens;
		
		int userMinLength = 4;
		int userMaxLength = 20;
		
		boolean userExists = false;
		
		//Opens UserPass.txt--------------------------------------------------------
		try {
			bufferedReader = new BufferedReader(new FileReader("src/UserPass.txt"));
			
			username = username_t.getText();
			passwordArray = password_t.getPassword();
			
			//checks if username field is empty
			if (username.equals("")) {
				warning_l.setText("Username cannot be empty.");
				
				bufferedReader.close();
				
				return false;	// since it was unable to register
			}
			
			//checks username for minimum length and maximum length
			if (username.length() <= userMinLength - 1 || username.length() > userMaxLength) {
				warning_l.setText("Username must be at least 4 characters and no greater than 20 characters.");
				
				bufferedReader.close();
				
				return false;
			}
			
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
				warning_l.setText("Username exists. Please use a different username.");
				
				bufferedReader.close();
				
				return false;	// since it was unable to register
			}
			
			bufferedWriter = new BufferedWriter(new FileWriter("src/UserPass.txt", true));
			password = "";
			
			for (int i = 0; i < passwordArray.length; i++)
			{
				password += passwordArray[i];
			}
			
			//checks password of for minimum and maximum length
			if (password.length() <= userMinLength - 1 || password.length() > userMaxLength) {
				warning_l.setText("Password must be at least 4 characters and no greater than 20 characters.");
				
				bufferedReader.close();
				bufferedWriter.close();
				
				return false;
			}
			
			//checks password for at least one special character
			for (int i = 0; i < username.length(); i++) {
				if (password.indexOf('!') < 0 && password.indexOf('@') < 0 && password.indexOf('#') < 0
						&& password.indexOf('$') < 0 && password.indexOf('%') < 0 && password.indexOf('&') < 0
						&& password.indexOf('?') < 0) {
					warning_l.setText("Password must contain at least one special character. Special characters include !@#$%&?");
					
					bufferedReader.close();
					bufferedWriter.close();
					
					return false;
				}
				
				else
					warning_l.setText("");;
			}
			
			//checks password for at least one integer
			for (int i = 0; i < username.length(); i++) {
				if (password.indexOf('1') < 0 && password.indexOf('2') < 0 && password.indexOf('3') < 0
						&& password.indexOf('4') < 0 && password.indexOf('5') < 0 && password.indexOf('6') < 0
						&& password.indexOf('7') < 0 && password.indexOf('8') < 0 && password.indexOf('9') < 0
						&& password.indexOf('0') < 0) {
					warning_l.setText("Password must contain at least one number.");
					
					bufferedReader.close();
					bufferedWriter.close();
					
					return false;
				}
				
				else
					warning_l.setText("");
			}
			
			//checks password of invalid characters
			for (int i = 0; i < username.length(); i++) {
				if (password.indexOf('"') > 0) {
					warning_l.setText("Password cannot contain the " + '"' + " character.");
					
					bufferedReader.close();
					bufferedWriter.close();
					
					return false;
				}
			}
			
			//prints valid username and password in UserPass.txt---
			encryptedUsername = encrypt(username);
			encryptedPassword = encrypt(password);
			
			bufferedWriter.write("\n" + username + " " + password);
			
			warning_l.setText("User created!");
			
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return true; //returns true if it was able to register and reach the end
	}

	private static String encrypt(String username) {
		
		return null;
	}

	//login function
	public static boolean login(JTextField username_t, JPasswordField password_t, JTextArea warning_l) {
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
					
					warning_l.setText("Login Successful!");
					
					return true;
				}
			}
			
			//reaches the end without matching credentials, returns false-----------------------------------------------
			bufferedReader.close();
					
			warning_l.setText("Login Unsuccessful. Please enter a valid username and password.");
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return false;
	}
	
}
