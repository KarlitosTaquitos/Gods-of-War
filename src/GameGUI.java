import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class GameGUI {
	private JFrame frame;
	
	public GameGUI() {
		frame = new JFrame("Gods of War");
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		mainScreen();
	}
	
	public static void main(String[] args) throws IOException {
		new GameGUI();
		
		//loads UserPass.txt, which contains user's usernames and passwords in "username password" format
		UserPassBackEnd.loadUserPassFile();
		
	}
	
	private void mainScreen() {
		//Clear the frame
		clearFrame();
		
		//Create buttons
		JButton login_b = new JButton("Login");
		login_b.setBounds(200, 275, 100, 50);
		
		JButton register_b = new JButton("Register");
		register_b.setBounds(500, 275, 100, 50);
		
		//-----------------------------------------------------
		
		//Login button listener
		login_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen();
			}
		});
		
		//Register button listener
		register_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerScreen();
			}
		});
		
		//-----------------------------------------------------
		
		//Add components to frame
		frame.add(login_b);
		frame.add(register_b);
	}
	
	private void clearFrame() {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	private void loginScreen() {
		//Clear frame
		clearFrame();
		
		//Create buttons, text fields, and labels
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, 100, 50);
		
		JLabel username_l = new JLabel("Username:");
		username_l.setBounds(150, 200, 100, 30);
		JTextField username_t = new JTextField();
		username_t.setBounds(300, 200, 200, 30);
		
		JLabel password_l = new JLabel("Password");
		password_l.setBounds(150, 285, 100, 30);
		JPasswordField password_t = new JPasswordField();
		password_t.setBounds(300, 285, 200, 30);
		
		JButton login_b = new JButton("Login");
		login_b.setBounds(550, 285, 200, 30);
		
		JTextArea warning_l = new JTextArea();
		warning_l.setBounds(300, 100, 200, 100);
		warning_l.setLineWrap(true);
		warning_l.setOpaque(false);
		
		//-----------------------------------------------------
		
		//Back button to main screen
		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});
		
		//Login button listener
		login_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logging in things
				if (UserPassBackEnd.login(username_t, password_t, warning_l))
					// if successful next screen
					loggedInScreen();
			}
		});
		
		//-----------------------------------------------------
		
		//Add components to frame
		frame.add(back_b);
		frame.add(username_l);
		frame.add(username_t);
		frame.add(password_l);
		frame.add(password_t);
		frame.add(login_b);
		frame.add(warning_l);
	}

	private void registerScreen() {
		//Clear frame
		clearFrame();
		
		//Create buttons, text fields, and labels
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, 100, 50);
		
		JLabel username_l = new JLabel("Username:");
		username_l.setBounds(150, 200, 100, 30);
		JTextField username_t = new JTextField();
		username_t.setBounds(300, 200, 200, 30);
		
		JLabel password_l = new JLabel("Password");
		password_l.setBounds(150, 285, 100, 30);
		JPasswordField password_t = new JPasswordField();
		password_t.setBounds(300, 285, 200, 30);
		
		JButton register_b = new JButton("Register");
		register_b.setBounds(550, 285, 200, 30);
		
		JTextArea warning_l = new JTextArea();
		warning_l.setBounds(300, 100, 200, 100);
		warning_l.setLineWrap(true);
		warning_l.setOpaque(false);
		
		//-----------------------------------------------------
		
		//Back button to main screen
		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});
		
		//Register button listener
		register_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registration things
				if (UserPassBackEnd.register(username_t, password_t, warning_l))
					// next screen
					loggedInScreen();
			}
		});
		
		//-----------------------------------------------------
		
		
		frame.add(back_b);
		frame.add(username_l);
		frame.add(username_t);
		frame.add(password_l);
		frame.add(password_t);
		frame.add(register_b);
		frame.add(warning_l);

	}

	private void loggedInScreen() {
		//Clear the frame
		clearFrame();
		
		//create labels, buttons
		JLabel welcome_l = new JLabel("Welcome, Warrior");
		welcome_l.setBounds(0, 0, 800, 300);
		welcome_l.setVerticalAlignment(JLabel.CENTER);
		welcome_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton load_b = new JButton("Load Game");
		load_b.setBounds(200, 375, 100, 30);
		
		JButton new_b = new JButton("New Game");
		new_b.setBounds(500, 375, 100, 30);
		
		//--------------------------------------------------------
		
		//Load game button
		load_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load file
				
				// explore screen
			}
		});
		
		new_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new game screen
				newGame();
			}
		});
		
		//--------------------------------------------------------
		
		//Add stuff to frame
		frame.add(welcome_l);
		frame.add(load_b);
		frame.add(new_b);
	}
	
	private void newGame() {
		//Clear the screen
		clearFrame();
		
		//Create labels and buttons
		JLabel title_l = new JLabel("New Game");
		title_l.setBounds(0, 0, 800, 100);
		title_l.setVerticalAlignment(JLabel.CENTER);
		title_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel size_l = new JLabel("Select World Size:");
		size_l.setBounds(0, 100, 800, 100);
		size_l.setVerticalAlignment(JLabel.CENTER);
		size_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton small_b = new JButton("Small");
		small_b.setBounds(150, 350, 100, 30);
		
		JButton medium_b = new JButton("Medium");
		medium_b.setBounds(350, 350, 100, 30);
		
		JButton large_b = new JButton("Large");
		large_b.setBounds(550, 350, 100, 30);
		
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, 100, 50);
		
		//--------------------------------------------------------
		
		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loggedInScreen();
			}
		});
		
		//--------------------------------------------------------
		
		//Add stuff to frame
		frame.add(title_l);
		frame.add(size_l);
		frame.add(small_b);
		frame.add(medium_b);
		frame.add(large_b);
		frame.add(back_b);
	}
}
