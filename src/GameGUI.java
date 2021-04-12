import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class GameGUI {
	private JFrame frame;
	private final int WIDTH = 800, HEIGHT = 600;
	private final int BUTTON_W = 100, BUTTON_H = 50;
	
	public GameGUI() {
		
		frame = new JFrame("Gods of War");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		//mainScreen();
		battleScreen();
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
		login_b.setBounds(200, 275, BUTTON_W, BUTTON_H);
		
		JButton register_b = new JButton("Register");
		register_b.setBounds(500, 275, BUTTON_W, BUTTON_H);
		
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
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
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
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
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
		load_b.setBounds(200, 375, BUTTON_W, BUTTON_H);
		
		JButton new_b = new JButton("New Game");
		new_b.setBounds(500, 375, BUTTON_W, BUTTON_H);
		
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
				newGameScreen();
			}
		});
		
		//--------------------------------------------------------
		
		//Add stuff to frame
		frame.add(welcome_l);
		frame.add(load_b);
		frame.add(new_b);
	}
	
	private void newGameScreen() {
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
		small_b.setBounds(150, 350, BUTTON_W, BUTTON_H);
		
		JButton medium_b = new JButton("Medium");
		medium_b.setBounds(350, 350, BUTTON_W, BUTTON_H);
		
		JButton large_b = new JButton("Large");
		large_b.setBounds(550, 350, BUTTON_W, BUTTON_H);
		
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		//--------------------------------------------------------
		
		// back button
		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go back to login screen
				loggedInScreen();
			}
		});
		
		// small button
		small_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create new small map game
				
				// go to explore screen
				exploreScreen();
			}
		});
		
		// medium button
		medium_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create new medium map game
				
				// go to explore screen
				exploreScreen();
			}
		});
		
		//large button
		large_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create new large map game
				
				// go to explore screen
				// beginning tile won't have enemy
				exploreScreen();
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
	
	private void exploreScreen() {
		//Clear the frame
		clearFrame();
		
		//temporary since other screens aren't showing up
		//GamePlay.newGame("username", 6);
		
		//Add things
		JButton spend_b = new JButton("Spend AP");
		spend_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		JButton save_b = new JButton("Save");
		save_b.setBounds(650, 50, BUTTON_W, BUTTON_H);
		
		JButton use_b = new JButton("Use Item");
		use_b.setBounds(50, 500, BUTTON_W, BUTTON_H);
		
		JButton quit_b = new JButton("Quit");
		quit_b.setBounds(650, 500, BUTTON_W, BUTTON_H);
		
		JButton up_b = new JButton("Up");
		up_b.setBounds(350, 150, BUTTON_W, BUTTON_H);
		
		JButton left_b = new JButton("Left");
		left_b.setBounds(200, 275, BUTTON_W, BUTTON_H);
		
		JButton right_b = new JButton("Right");
		right_b.setBounds(500, 275, BUTTON_W, BUTTON_H);
		
		JButton down_b = new JButton("Down");
		down_b.setBounds(350, 400, BUTTON_W, BUTTON_H);
		
		//------------------------------------------------------
		
		//Spend AP button
		spend_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spend AP screen
				spendAPScreen();
			}
		});
		
		//Save button
		save_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save
			}
		});
		
		//Use item button
		use_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Use Item screen
				useItemScreen(0); //send 0 so it'll go back to explore screen
			}
		});
		
		//Quit button
		quit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Quit
				System.exit(0);
			}
		});
		
		//Up button
		up_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move up
				ExploreMapBackEnd.moveUp(GamePlay.player, GamePlay.map);
			}
		});
		
		//Left button
		left_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move left
				ExploreMapBackEnd.moveLeft(GamePlay.player, GamePlay.map);
			}
		});
		
		//Right button
		right_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move right
				ExploreMapBackEnd.moveRight(GamePlay.player, GamePlay.map);
			}
		});
		
		//Down button
		down_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move down
				ExploreMapBackEnd.moveDown(GamePlay.player, GamePlay.map);
			}
		});
		
		//------------------------------------------------------
		
		frame.add(spend_b);
		frame.add(save_b);
		frame.add(use_b);
		frame.add(quit_b);
		
		frame.add(up_b);
		frame.add(left_b);
		frame.add(right_b);
		frame.add(down_b);
	}
	
	private void spendAPScreen() {
		//Clear frame
		clearFrame();
		
		//Add stuff
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		JButton str_b = new JButton("STR");
		str_b.setBounds(110, 375, BUTTON_W, BUTTON_H);
		
		JButton con_b = new JButton("CON");
		con_b.setBounds(270, 375, BUTTON_W, BUTTON_H);
		
		JButton spd_b = new JButton("SPD");
		spd_b.setBounds(430, 375, BUTTON_W, BUTTON_H);
		
		JButton int_b = new JButton("INT");
		int_b.setBounds(590, 375, BUTTON_W, BUTTON_H);
		
		//-----------------------------------------------
		
		//Back button
		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exploreScreen();
			}
		});
		
		//Strength button
		str_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Str stuff
				SpendAPBackEnd.increaseSTR(GamePlay.player);
			}
		});
		
		//Constitution button
		con_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//con stuff
				SpendAPBackEnd.increaseCON(GamePlay.player);
			}
		});
				
		//Speed button
		spd_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spd stuff
				SpendAPBackEnd.increaseSPD(GamePlay.player);
			}
		});
		
		//Intelligence button
		int_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Int stuff
				SpendAPBackEnd.increaseINT(GamePlay.player);
			}
		});
		
		//-----------------------------------------------
		
		//Add them to frame
		frame.add(back_b);
		frame.add(str_b);
		frame.add(con_b);
		frame.add(spd_b);
		frame.add(int_b);
	}

	private void battleScreen() {
		//Clear frame
		clearFrame();
		
		//temporary since other screens aren't showing up
		GamePlay.newGame("username", 6);
		
		//Add components
		JButton attack_b = new JButton("Attack");
		attack_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		
		JButton use_b = new JButton("Use Item");
		use_b.setBounds((int)(WIDTH / 2 - BUTTON_W * 1.5), HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton flee_b = new JButton("Flee");
		flee_b.setBounds(WIDTH / 2 + BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		//-----------------------------------------------
		
		//Attack button
		attack_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Attack stuff
			}
		});
		
		//Use button
		use_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Use item screen
				useItemScreen(1); //send 1 so it will send us back to battle screen
			}
		});
		
		//Flee button
		flee_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Flee stuff
				BattleBackEnd.flee(GamePlay.player);
				
				exploreScreen();
			}
		});
	
		//-----------------------------------------------
		
		frame.add(attack_b);
		frame.add(use_b);
		frame.add(flee_b);
	}
	
	
	private void useItemScreen(int screen) {
		//Clear the frame
		clearFrame();
		
		//temporary since other screens aren't showing up
		//GamePlay.newGame("username", 6);
		
		//Add buttons
		JButton food_b = new JButton("Food");
		food_b.setBounds(WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton small_b = new JButton("Small Pot");
		small_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);

		JButton large_b = new JButton("Large Pot");
		large_b.setBounds(3 * WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		//----------------------------------------------
		
		//Food button
		food_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//food
				Food newFood = new Food();
				
				ConsumableBackEnd.useConsumable(GamePlay.player, newFood);
			}
		});
		
		//Small pot button
		small_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//small pot
				smPot newSMPot = new smPot();
				
				ConsumableBackEnd.useConsumable(GamePlay.player, newSMPot);
			}
		});
		
		//Large Pot button
		large_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//large pot
				lgPot newLGPot = new lgPot();
				
				ConsumableBackEnd.useConsumable(GamePlay.player, newLGPot);
			}
		});

		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (screen == 0)
					exploreScreen();
				else if (screen == 1)
					battleScreen();
				else //for some reason some other number is passed
					exploreScreen();
			}
		});
		
		//----------------------------------------------
		
		frame.add(food_b);
		frame.add(small_b);
		frame.add(large_b);
		frame.add(back_b);
	}
}
