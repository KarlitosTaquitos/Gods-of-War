import java.io.*;

public class Player implements GameElement {
	
	//string that stores the player's name
	String name;
	
	//array that holds the player's position in the map
	// [x, y]
	int[] position = new int[2];
	
	//various player variables
	public int hp; //health points
	public int bd; //base damage
	public int APpool; //attribute pool
	public int enemiesDefeated; //how many enemies player has defeated
	public int playerDefeat; //how many times the player was defeated
	
	//variables that represent the player's attributes
	public int STR; //strength
	public int INT; //intelligence
	public int CON; //constitution
	public int SPD; //speed
	
	//variables that represent the player's total number of consumables
	public int food;
	public int smPot; //small potion
	public int lgPot; //large potion
	
	//stores location of last rest area
	public int[] lastRestArea = new int[2];
	
	//blank constructor
	// required for Enemies subclass
	public Player() {
	}
	
	//constructor for player when given a username
	Player(String username) {
		
		//sets player's name to username given
		this.name = username;
		
		//sets player's position to the starting Area
		this.position[0] = 1;
		this.position[1] = 1;
		
		//sets player stats to beginning stats
		//normally set to 0;
		//change for testing
		this.APpool = 0;
		//player hit points set to 90 for testing
		//normally set to 100;
		//change for testing
		this.hp = 100;
		this.bd = 10;
		this.enemiesDefeated = 0;
		this.playerDefeat = 0;
		
		//sets player attributes to beginning attributes
		this.STR = 5;
		this.INT = 5;
		this.CON = 5;
		this.SPD = 5;
		
		//normally, player starts with no consumables
		//change for testing
		this.food = 0;
		this.smPot = 0;
		this.lgPot = 0;
		
		this.lastRestArea[0] = 1;
		this.lastRestArea[1] = 1;
	
	}
	
	public Player(String playerName, int playerPosX, int playerPosY, int playerAPpool, int playerHP, int playerBD,
			int playerEnemiesDefeated, int playerPlayerDefeat, int playerSTR, int playerINT, int playerCON, int playerSPD,
			int playerFood, int playerSMPot, int playerLGPot, int playerLastRestAreaX, int playerLastRestAreaY) {
		
		this.name = playerName;
		
		this.position[0] = playerPosX;
		this.position[1] = playerPosY;
		
		this.APpool = playerAPpool;
		this.hp = playerHP;
		this.bd = playerBD;
		this.enemiesDefeated = playerEnemiesDefeated;
		this.playerDefeat = playerPlayerDefeat;
		
		this.STR = playerSTR;
		this.INT = playerINT;
		this.CON = playerCON;
		this.SPD = playerSPD;
		
		this.food = playerFood;
		this.smPot = playerSMPot;
		this.lgPot = playerLGPot;
		
		this.lastRestArea[0] = playerLastRestAreaX;
		this.lastRestArea[1] = playerLastRestAreaY;
	}

	//function that creates a player with given username
	static Player makePlayer(String username) {
		
		Player userPlayer = new Player(username);
		
		GamePlay.player = userPlayer;
		
		return userPlayer;
	}
	
	static Player makePlayer(String playerName, int playerPosX, int playerPosY, int playerAPpool, int playerHP, int playerBD,
			int playerEnemiesDefeated, int playerPlayerDefeat, int playerSTR, int playerINT, int playerCON, int playerSPD,
			int playerFood, int playerSMPot, int playerLGPot, int playerLastRestAreaX, int playerLastRestAreaY) {
	
		Player madePlayer = new Player(playerName, playerPosX, playerPosY, playerAPpool, playerHP, playerBD,
				playerEnemiesDefeated, playerPlayerDefeat, playerSTR, playerINT, playerCON, playerSPD,
				playerFood, playerSMPot, playerLGPot, playerLastRestAreaX, playerLastRestAreaY);
		
		return madePlayer;
		
	}

	//function that saves the player's state
	public void write(String filename) throws IOException {
		BufferedWriter saver = new BufferedWriter(new FileWriter(filename, true));
		
		saver.write("Player information.");
		saver.write("\n" + "playerName " + GamePlay.player.name);
		saver.write("\n" + "playerPositionX " + GamePlay.player.position[0]);
		saver.write("\n" + "playerPositionY " + GamePlay.player.position[1]);
		saver.write("\n" + "playerAPpool " + GamePlay.player.APpool);
		saver.write("\n" + "playerHP " + GamePlay.player.hp);
		saver.write("\n" + "playerBD " + GamePlay.player.bd);
		saver.write("\n" + "playerEnemiesDefeated " + GamePlay.player.enemiesDefeated);
		saver.write("\n" + "playerPlayerDefeat " + GamePlay.player.playerDefeat);
		saver.write("\n" + "playerSTR " + GamePlay.player.STR);
		saver.write("\n" + "playerINT " + GamePlay.player.INT);
		saver.write("\n" + "playerCON " + GamePlay.player.CON);
		saver.write("\n" + "playerSPD " +GamePlay. player.SPD);
		saver.write("\n" + "playerFood " + GamePlay.player.food);
		saver.write("\n" + "playerSMPot " + GamePlay.player.smPot);
		saver.write("\n" + "playerLGPot " + GamePlay.player.lgPot);
		saver.write("\n" + "playerLastRestAreaX " + GamePlay.player.lastRestArea[0]);
		saver.write("\n" + "playerLastRestAreaY " + GamePlay.player.lastRestArea[1]);
		saver.write("\n" + "End of Player information");
		saver.write("\n");
		
		saver.close();
	}

}
