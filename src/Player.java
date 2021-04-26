
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
	public int areasFound; //number of distinct areas vsited
	
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

		//set amount of areas found to be 0
		areasFound = 0;
	}
	
	//function that creates a player with given username
	static Player makePlayer(String username) {
		
		Player userPlayer = new Player(username);
		
		GamePlay.player = userPlayer;
		
		return userPlayer;
	}

	//function that saves the player's state
	@Override
	public void write() {
	}
	

}
