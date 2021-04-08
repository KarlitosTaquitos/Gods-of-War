
public class GamePlay {
	
	//stores the state of the player
	Player player;
	
	//stores the state of the map
	Map map;
	
	//constructor
	GamePlay(String username, int mapSize) {
		this.player = new Player(username);
		
		this.map = new Map(mapSize);
	}
	
	//function that creates a new game with new username and map
	void newGame(String username, int mapSize) {
		new GamePlay(username, mapSize);
	}
}
