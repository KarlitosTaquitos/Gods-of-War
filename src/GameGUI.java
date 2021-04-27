import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class GameGUI {
	private JFrame frame;
	private final int WIDTH = 600, HEIGHT = 400;
	private final int BUTTON_W = 100, BUTTON_H = 50;
	
	protected String playerName;
	private String exploreMessage;
	private String battlePMessage;
	
	public GameGUI() {
		exploreMessage = "";
		frame = new JFrame("Gods of War");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		titleScreen();
	}
	
	public static void main(String[] args) throws IOException {
		new GameGUI();
	}
	
	private void titleScreen() {
		clearFrame();

		JLabel title_l = new JLabel("Gods of War");
		title_l.setBounds(0, 0, WIDTH, HEIGHT * 2 / 3);
		title_l.setVerticalAlignment(JLabel.CENTER);
		title_l.setHorizontalAlignment(JLabel.CENTER);

		JButton start_b = new JButton("Start");
		start_b.setBounds(WIDTH / 3 - BUTTON_W / 2, HEIGHT * 2 / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);

		JButton quit_b = new JButton("Quit");
		quit_b.setBounds(WIDTH * 2 / 3 - BUTTON_W / 2, HEIGHT * 2 / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);

		start_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});

		quit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		frame.add(title_l);
		frame.add(start_b);
		frame.add(quit_b);
	}

	private void mainScreen() {
		//Clear the frame
		clearFrame();
		
		//Create buttons
		JButton login_b = new JButton("Login");
		login_b.setBounds(WIDTH / 3 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton register_b = new JButton("Register");
		register_b.setBounds(2 * WIDTH / 3 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
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
		username_l.setBounds(WIDTH / 5, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, 30);
		JTextField username_t = new JTextField();
		username_t.setBounds(WIDTH / 3, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W * 2, 30);
		
		JLabel password_l = new JLabel("Password");
		password_l.setBounds(WIDTH / 5, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W, 30);
		JPasswordField password_t = new JPasswordField();
		password_t.setBounds(WIDTH / 3, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W * 2, 30);
		
		JButton login_b = new JButton("Login");
		login_b.setBounds(WIDTH / 2, 4 * HEIGHT / 5, BUTTON_W, BUTTON_H);
		
		JLabel warning_l = new JLabel();
		warning_l.setBounds(WIDTH / 3, HEIGHT / 8, WIDTH / 3, HEIGHT / 4);
		warning_l.setVerticalAlignment(JLabel.CENTER);
		
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
				playerName = username_t.getText();
				
				Player.makePlayer(playerName);
				
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
		username_l.setBounds(WIDTH / 5, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, 30);
		JTextField username_t = new JTextField();
		username_t.setBounds(WIDTH / 3, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W * 2, 30);
		
		JLabel password_l = new JLabel("Password");
		password_l.setBounds(WIDTH / 5, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W, 30);
		JPasswordField password_t = new JPasswordField();
		password_t.setBounds(WIDTH / 3, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W * 2, 30);
		
		JButton register_b = new JButton("Register");
		register_b.setBounds(WIDTH / 2, 4 * HEIGHT / 5, BUTTON_W, BUTTON_H);
		
		JLabel warning_l = new JLabel();
		warning_l.setBounds(WIDTH / 3, HEIGHT / 8, WIDTH / 3, HEIGHT / 4);
		warning_l.setVerticalAlignment(JLabel.CENTER);
		
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
				playerName = username_t.getText();
				
				Player.makePlayer(playerName);
				
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
		welcome_l.setBounds(0, 0, WIDTH, HEIGHT / 2);
		welcome_l.setVerticalAlignment(JLabel.CENTER);
		welcome_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton load_b = new JButton("Load Game");
		load_b.setBounds(WIDTH / 3 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton new_b = new JButton("New Game");
		new_b.setBounds(2 * WIDTH / 3 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);

		JLabel warning_b = new JLabel();
		warning_b.setBounds(0, 100, WIDTH, HEIGHT / 2 - 100);
		warning_b.setVerticalAlignment(JLabel.CENTER);
		warning_b.setHorizontalAlignment(JLabel.CENTER);
		
		//--------------------------------------------------------
		
		//Load game button
		load_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//load the user's save file
				if (LoadSavedGame.loadSave())
					// explore screen
					exploreScreen();
				else
					// state that something went wrong
					warning_b.setText("Something went wrong loading the file. Please create a new game. :(");
			}
		});
		
		new_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new game screen
				GamePlay.player = Player.makePlayer(playerName);
				
				newGameScreen();
			}
		});
		
		//--------------------------------------------------------
		
		//Add stuff to frame
		frame.add(welcome_l);
		frame.add(load_b);
		frame.add(new_b);
		frame.add(warning_b);
	}
	
	private void newGameScreen() {
		//Clear the screen
		clearFrame();
		
		//Create labels and buttons
		JLabel title_l = new JLabel("New Game");
		title_l.setBounds(0, 0, WIDTH, BUTTON_H * 2);
		title_l.setVerticalAlignment(JLabel.CENTER);
		title_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel size_l = new JLabel("Select World Size:");
		size_l.setBounds(0, BUTTON_H * 2, WIDTH, BUTTON_H * 2);
		size_l.setVerticalAlignment(JLabel.CENTER);
		size_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton small_b = new JButton("Small");
		small_b.setBounds(WIDTH / 4 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton medium_b = new JButton("Medium");
		medium_b.setBounds(WIDTH / 2 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton large_b = new JButton("Large");
		large_b.setBounds(3 * WIDTH / 4 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
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
				GamePlay.map = Map.makeMap(7);
				
				// go to explore screen
				exploreScreen();
			}
		});
		
		// medium button
		medium_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create new medium map game
				GamePlay.map = Map.makeMap(9);
				
				// go to explore screen
				exploreScreen();
			}
		});
		
		//large button
		large_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create new large map game
				GamePlay.map = Map.makeMap(11);
				
				// go to explore screen
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
		
		//Add things
		JButton spend_b = new JButton("Spend AP");
		spend_b.setBounds(50, 50, BUTTON_W, BUTTON_H * 3 / 4);
		
		JButton save_b = new JButton("Save");
		save_b.setBounds(WIDTH - BUTTON_W - 50, 50, BUTTON_W * 3 / 4, BUTTON_H);
		
		JButton use_b = new JButton("Use Item");
		use_b.setBounds(50, HEIGHT - BUTTON_H - 75, BUTTON_W, BUTTON_H);
		
		JButton quit_b = new JButton("Quit");
		quit_b.setBounds(WIDTH - BUTTON_W - 50, HEIGHT - BUTTON_H - 75, BUTTON_W * 3 / 4, BUTTON_H);
		
		JButton up_b = new JButton("Up");
		up_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H - 25, BUTTON_W * 3 / 4, BUTTON_H);
		
		JButton left_b = new JButton("Left");
		left_b.setBounds(WIDTH / 2 - BUTTON_W - 25, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W * 3 / 4, BUTTON_H);
		
		JButton right_b = new JButton("Right");
		right_b.setBounds(WIDTH / 2 + 25, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W * 3 / 4, BUTTON_H);
		
		JButton down_b = new JButton("Down");
		down_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 + 25, BUTTON_W * 3 / 4, BUTTON_H);
		
		JLabel message_l = new JLabel();
		message_l.setBounds(WIDTH / 4, 0, WIDTH / 2, HEIGHT / 2 - 50 - BUTTON_H);
		message_l.setVerticalAlignment(JLabel.CENTER);
		message_l.setHorizontalAlignment(JLabel.CENTER);
		
		//message for player hit points
		JLabel pMessage_l = new JLabel();
		pMessage_l.setBounds(WIDTH / 3, HEIGHT - BUTTON_H - 75, WIDTH / 3, BUTTON_H * 2);
		pMessage_l.setVerticalAlignment(JLabel.CENTER);
		pMessage_l.setHorizontalAlignment(JLabel.CENTER);
		
		//Put player hit points and ap pool on screen
		pMessage_l.setText("<html> Your hp: " + GamePlay.player.hp + "<br/>Your unspent AP: " + GamePlay.player.APpool + "<br/></html>");
		
		//Put position on screen
		if (exploreMessage == "") {
			int xPos = GamePlay.player.position[0];
			int yPos = GamePlay.player.position[1];
		
			String pos_s = "Position: ";
			pos_s = pos_s + xPos + ", " + yPos;
		
			message_l.setText(pos_s);
		}
		
		else if (exploreMessage == "You were defeated!") {
			int xPos = GamePlay.player.position[0];
			int yPos = GamePlay.player.position[1];
		
			String pos_s = "You were defeated! Position: ";
			pos_s = pos_s + xPos + ", " + yPos;
		
			message_l.setText(pos_s);
		}
		
		else message_l.setText(exploreMessage);
		
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
				SaveGame.saveGameFile(GamePlay.player, GamePlay.map);
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
				//System.exit(0);
				quitScreen(false);
			}
		});
		
		//Up button
		up_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move up
				message_l.setText("<html>");
				ExploreMapBackEnd.moveUp(GamePlay.player, GamePlay.map, message_l);
				message_l.setText(message_l.getText() + "</html>");
				exploreMessage = message_l.getText();
				
				//If enemy, send to battle screen
				if (ExploreMapBackEnd.isThereEnemy(GamePlay.player, GamePlay.map) != null) {
					battlePMessage = ExploreMapBackEnd.enemyHereMessage(GamePlay.player, GamePlay.map);
					battleScreen();
				}
			}
		});
		
		//Left button
		left_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move left
				message_l.setText("<html>");
				ExploreMapBackEnd.moveLeft(GamePlay.player, GamePlay.map, message_l);
				message_l.setText(message_l.getText() + "</html>");
				exploreMessage = message_l.getText();
				
				//Check for enemy and send to battle screen
				if (ExploreMapBackEnd.isThereEnemy(GamePlay.player, GamePlay.map) != null) {
					battlePMessage = ExploreMapBackEnd.enemyHereMessage(GamePlay.player, GamePlay.map);
					battleScreen();
				}
			}
		});
		
		//Right button
		right_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Move right
				message_l.setText("<html>");
				ExploreMapBackEnd.moveRight(GamePlay.player, GamePlay.map, message_l);
				message_l.setText(message_l.getText() + "</html>");
				exploreMessage = message_l.getText();
				
				//If there's an enemy, go to battle screen
				if (ExploreMapBackEnd.isThereEnemy(GamePlay.player, GamePlay.map) != null) {
					battlePMessage = ExploreMapBackEnd.enemyHereMessage(GamePlay.player, GamePlay.map);
					battleScreen();
				}
			}
		});
		
		//Down button
		down_b.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//Move down
				message_l.setText("<html>");
				ExploreMapBackEnd.moveDown(GamePlay.player, GamePlay.map, message_l);
				message_l.setText(message_l.getText() + "</html>");
				exploreMessage = message_l.getText();
				
				//If enemy, battle screen
				if (ExploreMapBackEnd.isThereEnemy(GamePlay.player, GamePlay.map) != null) {
					battlePMessage = ExploreMapBackEnd.enemyHereMessage(GamePlay.player, GamePlay.map);
					battleScreen();
				}
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
		
		frame.add(message_l);
		//add player hit points message to screen
		frame.add(pMessage_l);
	}
	
	private void spendAPScreen() {
		//Clear frame
		clearFrame();
		
		//Add stuff
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		//Buttons are split evenly across screen, 2/3 of the way down
		JButton str_b = new JButton("STR");
		str_b.setBounds(WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JLabel str_l = new JLabel("" + GamePlay.player.STR);
		str_l.setBounds(WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		str_l.setVerticalAlignment(JLabel.CENTER);
		str_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton con_b = new JButton("CON");
		con_b.setBounds(2 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JLabel con_l = new JLabel("" + GamePlay.player.CON);
		con_l.setBounds(2 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		con_l.setVerticalAlignment(JLabel.CENTER);
		con_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton spd_b = new JButton("SPD");
		spd_b.setBounds(3 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JLabel spd_l = new JLabel("" + GamePlay.player.SPD);
		spd_l.setBounds(3 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		spd_l.setVerticalAlignment(JLabel.CENTER);
		spd_l.setHorizontalAlignment(JLabel.CENTER);
		
		JButton int_b = new JButton("INT");
		int_b.setBounds(4 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JLabel int_l = new JLabel("" + GamePlay.player.INT);
		int_l.setBounds(4 * WIDTH / 5 - BUTTON_W / 2, 2 * HEIGHT / 3 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		int_l.setVerticalAlignment(JLabel.CENTER);
		int_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel message_l = new JLabel();
		message_l.setBounds(WIDTH / 4, 50, WIDTH / 2, HEIGHT / 2 - 100 - BUTTON_H);
		message_l.setVerticalAlignment(JLabel.CENTER);
		message_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel amount_l = new JLabel();
		amount_l.setBounds(WIDTH - 300, 25, 200, 50);
		amount_l.setVerticalAlignment(JLabel.CENTER);
		amount_l.setHorizontalAlignment(JLabel.CENTER);
		amount_l.setText("You have " + GamePlay.player.APpool + " Attribute Points!");
		
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
				message_l.setText("<html>");
				SpendAPBackEnd.increaseSTR(GamePlay.player, message_l);
				message_l.setText(message_l.getText() + "</html>");
				str_l.setText("" + GamePlay.player.STR);
				frame.repaint();
			}
		});
		
		//Constitution button
		con_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//con stuff
				message_l.setText("<html>");
				SpendAPBackEnd.increaseCON(GamePlay.player, message_l);
				message_l.setText(message_l.getText() + "</html>");
				con_l.setText("" + GamePlay.player.CON);
				frame.repaint();
			}
		});
				
		//Speed button
		spd_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Spd stuff
				message_l.setText("<html>");
				SpendAPBackEnd.increaseSPD(GamePlay.player, message_l);
				message_l.setText(message_l.getText() + "</html>");
				spd_l.setText("" + GamePlay.player.SPD);
				frame.repaint();
			}
		});
		
		//Intelligence button
		int_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Int stuff
				message_l.setText("<html>");
				SpendAPBackEnd.increaseINT(GamePlay.player, message_l);
				message_l.setText(message_l.getText() + "</html>");
				int_l.setText("" + GamePlay.player.INT);
				frame.repaint();
			}
		});
		
		//-----------------------------------------------
		
		//Add them to frame
		frame.add(back_b);
		frame.add(str_b);
		frame.add(con_b);
		frame.add(spd_b);
		frame.add(int_b);
		
		frame.add(str_l);
		frame.add(con_l);
		frame.add(spd_l);
		frame.add(int_l);
		
		frame.add(message_l);
		frame.add(amount_l);
	}

	private void battleScreen() {
		//Clear frame
		clearFrame();
		
		//Add components
		JButton attack_b = new JButton("Attack");
		attack_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H * 2, BUTTON_W, BUTTON_H);
		
		JButton use_b = new JButton("Use Item");
		use_b.setBounds((int)(WIDTH / 2 - BUTTON_W * 1.5), HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton flee_b = new JButton("Flee");
		flee_b.setBounds(WIDTH / 2 + BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton leave_b = new JButton("Leave");
		leave_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 + 50, BUTTON_W, BUTTON_H);
		
		JLabel pMessage_l = new JLabel();
		pMessage_l.setBounds(WIDTH / 5, 10, WIDTH / 5, HEIGHT / 2 - BUTTON_H);
		pMessage_l.setVerticalAlignment(JLabel.CENTER);
		pMessage_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel eMessage_l = new JLabel();
		eMessage_l.setBounds(3 * WIDTH / 5, 10, WIDTH / 5, HEIGHT / 2 - BUTTON_H);
		eMessage_l.setVerticalAlignment(JLabel.CENTER);
		eMessage_l.setHorizontalAlignment(JLabel.CENTER);
		
		if (battlePMessage != "")
			pMessage_l.setText(battlePMessage);
		else pMessage_l.setText("idk");
		
		//-----------------------------------------------
		
		//Attack button
		attack_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Attack stuff
				Enemies enemy = Map.map[GamePlay.player.position[0]][GamePlay.player.position[1]].areaEnemy;
				
				pMessage_l.setText("<html> Your hp: " + GamePlay.player.hp + "<br/>");
				if (BattleBackEnd.attack(GamePlay.player, enemy, pMessage_l)) {
					if (enemy.getClass() == Boss.class)
						quitScreen(true);
					else {
						frame.add(leave_b);
						frame.repaint();
					}
				}
				pMessage_l.setText(pMessage_l.getText() + "</html>");
				
				eMessage_l.setText("<html>" + enemy.name + "'s hp: " + enemy.hp + "<br/>");
				if (BattleBackEnd.enemyAttack(enemy, GamePlay.player, eMessage_l)) {
					exploreMessage = "You were defeated!";
					exploreScreen();
				}
				
				eMessage_l.setText(eMessage_l.getText() + "</html>");
			}
		});
		
		//Use Item button
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
				exploreMessage = exploreMessage.replace("</html>", BattleBackEnd.flee(GamePlay.player) + "</html>");
				
				exploreScreen();
			}
		});
		
		//Leave button
		leave_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exploreScreen();
			}
		});
	
		//-----------------------------------------------
		
		frame.add(attack_b);
		frame.add(use_b);
		frame.add(flee_b);
		
		frame.add(pMessage_l);
		frame.add(eMessage_l);
	}
	
	private void useItemScreen(int screen) {
		//Clear the frame
		clearFrame();
		
		//Add buttons
		JButton food_b = new JButton("Food");
		food_b.setBounds(WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton small_b = new JButton("Small Pot");
		small_b.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);

		JButton large_b = new JButton("Large Pot");
		large_b.setBounds(3 * WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 - BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W, BUTTON_H);
		
		JLabel message_l = new JLabel();
		message_l.setBounds(WIDTH / 4, 50, WIDTH / 2, HEIGHT / 2 - 100 - BUTTON_H);
		message_l.setVerticalAlignment(JLabel.CENTER);
		message_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel food_l = new JLabel();
		food_l.setBounds(WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W, BUTTON_H);
		food_l.setVerticalAlignment(JLabel.CENTER);
		food_l.setHorizontalAlignment(JLabel.CENTER);

		JLabel small_l = new JLabel();
		small_l.setBounds(WIDTH / 2 - BUTTON_W / 2, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W, BUTTON_H);
		small_l.setVerticalAlignment(JLabel.CENTER);
		small_l.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel large_l = new JLabel();
		large_l.setBounds(3 * WIDTH / 4 - BUTTON_W / 2, HEIGHT / 2 + BUTTON_H / 2, BUTTON_W, BUTTON_H);
		large_l.setVerticalAlignment(JLabel.CENTER);
		large_l.setHorizontalAlignment(JLabel.CENTER);
		
		food_l.setText("You have: " + GamePlay.player.food);
		small_l.setText("You have: " + GamePlay.player.smPot);
		large_l.setText("You have: " + GamePlay.player.lgPot);
		
		JLabel hp_l = new JLabel("Your hp: " + GamePlay.player.hp);
		hp_l.setBounds(WIDTH - BUTTON_W - 50, 50, BUTTON_W, BUTTON_H);
		hp_l.setVerticalAlignment(JLabel.CENTER);
		hp_l.setHorizontalAlignment(JLabel.CENTER);

		//----------------------------------------------
		
		//Food button
		food_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//food
				Food newFood = new Food();
				
				message_l.setText("<html>");
				ConsumableBackEnd.useConsumable(GamePlay.player, newFood, message_l);
				message_l.setText(message_l.getText() + "</html>");
				
				food_l.setText("You have: " + GamePlay.player.food);
				hp_l.setText("Your hp: " + GamePlay.player.hp);
			}
		});
		
		//Small pot button
		small_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//small pot
				smPot newSMPot = new smPot();
				
				message_l.setText("<html>");
				ConsumableBackEnd.useConsumable(GamePlay.player, newSMPot, message_l);
				message_l.setText(message_l.getText() + "</html>");
			
				small_l.setText("You have: " + GamePlay.player.smPot);
				hp_l.setText("Your hp: " + GamePlay.player.hp);
			}
		});
		
		//Large Pot button
		large_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//large pot
				lgPot newLGPot = new lgPot();
				
				message_l.setText("<html>");
				ConsumableBackEnd.useConsumable(GamePlay.player, newLGPot, message_l);
				message_l.setText(message_l.getText() + "</html>");
			
				large_l.setText("You have: " + GamePlay.player.lgPot);
				hp_l.setText("Your hp: " + GamePlay.player.hp);
			}
		});

		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (screen == 0)
					exploreScreen();
				else if (screen == 1)
					battleScreen();
				else //for some reason some other number is passed
					exploreScreen(); //just go back to the explore screen lol
			}
		});
		
		//----------------------------------------------
		
		frame.add(food_b);
		frame.add(small_b);
		frame.add(large_b);
		frame.add(back_b);
		
		frame.add(message_l);
		frame.add(food_l);
		frame.add(small_l);
		frame.add(large_l);
		frame.add(hp_l);
	}

	private void quitScreen(boolean bossDefeated) {
		clearFrame();

		JLabel message_l = new JLabel();
		message_l.setBounds(WIDTH / 3, HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
		message_l.setVerticalAlignment(JLabel.CENTER);
		message_l.setHorizontalAlignment(JLabel.CENTER);
		ExploreMapBackEnd.postGameStats(GamePlay.player, bossDefeated, message_l);

		JButton quit_b = new JButton("Quit");
		quit_b.setBounds(3 * WIDTH / 4 - BUTTON_W / 2, 2 * HEIGHT / 3 + BUTTON_H / 2, BUTTON_W, BUTTON_H);
		
		JButton scores_b = new JButton("High Scores");
		scores_b.setBounds(WIDTH / 4 - BUTTON_W / 2, 2 * HEIGHT / 3 + BUTTON_H / 2, BUTTON_W, BUTTON_H);

		JButton save_b = new JButton("Save Score");
		save_b.setBounds(WIDTH / 2 - BUTTON_W / 2, 2 * HEIGHT / 3 + BUTTON_H / 2, BUTTON_W, BUTTON_H);

		quit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		scores_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//High score screen
				highScoreScreen(bossDefeated);
			}
		});

		save_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HighScoreBackEnd.addScore(GamePlay.player, ExploreMapBackEnd.score(GamePlay.player, bossDefeated));
			}
		});

		frame.add(message_l);
		frame.add(quit_b);
		frame.add(scores_b);
		frame.add(save_b);
	}

	public void highScoreScreen(boolean boss) {
		clearFrame();

		JLabel scores_l = new JLabel();
		scores_l.setBounds(WIDTH / 3, 0, WIDTH / 3, HEIGHT);

		JButton back_b = new JButton("Back");
		back_b.setBounds(50, 50, BUTTON_W * 3/4, BUTTON_H * 3/4);

		try {
			scores_l.setText(HighScoreBackEnd.getScores());
		}
		catch (Exception e) {
			scores_l.setText("Error in retrieving high scores");
		}

		back_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitScreen(boss);
			}
		});

		frame.add(scores_l);
		frame.add(back_b);
	}
}
