
public class Player implements GameElement {
	
	//string that stores the player's name
	String name;
	
	//array that holds the player's position in the map
	// [x, y]
	int[] position = new int[2];
	
	//variables that hold hp, base damage, and AP pool
	public int hp; //health points
	public int bd; //base damage
	public int APpool; //attribute pool
	
	//variables that represent the player's attributes
	public int STR; //strength
	public int INT; //intelligence
	public int CON; //constitution
	public int SPD; //speed
	
	//variables that represent the player's total number of consumables
	public int food;
	public int smPot; //small potion
	public int lgPot; //large potion
	
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
		//player AP set to 5 for testing.
		//normally set to 0;
		this.APpool = 5;
		//player hp set to 90 for testing
		//normally set to 100;
		this.hp = 25;
		this.bd = 10;
		
		//sets player attributes to beginning attributes
		this.STR = 5;
		this.INT = 5;
		this.CON = 5;
		this.SPD = 5;
		
		//player starting with consumables for testing
		//normally, player starts with no consumables
		this.food = 2;
		this.smPot = 2;
		this.lgPot = 2;
	
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
