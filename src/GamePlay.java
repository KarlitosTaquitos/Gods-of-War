
public class GamePlay {
	
	//stores the state of the player
	public static Player player;
	
	//stores the state of the map
	public static Map map;
	
	//constructor
	GamePlay(String username, int mapSize) {
		player = Player.makePlayer(username);
		
		map = Map.makeMap(mapSize);
	}
	
	//function that creates a new game with new username and map
	static void newGame(String username, int mapSize) {
		new GamePlay(username, mapSize);
	}
}
