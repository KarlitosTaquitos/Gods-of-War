
public class ExploreMapBackEnd {
	
	//function that determines if player is at upward map boundary
	public boolean playerAtUpBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		//if player's y position is == to mapSize,
		// they are at the upward boundary
		// (e.g if player position is [1, 6], player is at upward boundary)
		if (player.position[1] == mapSize) {
			atBoundary = true;
			
			System.out.println("Player is at upward boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}

	//function that determines if player is at downward map boundary
	public boolean playerAtDownBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[1] == 1) {
			atBoundary = true;
			
			System.out.println("Player is at downward boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at left boundary
	public boolean playerAtLeftBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[0] == 1) {
			atBoundary = true;
			
			System.out.println("Player is at left boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at right boundary
	public boolean playerAtRightBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[0] == mapSize) {
			atBoundary = true;
			
			System.out.println("Player is at right boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that outputs player's current position BEFORE moving and sets current Area's playerInArea to false
	public void beforeMoveDisplayUpdate(Player player, Map map) {

		//outputs player's current position before moving up
		System.out.print("Player's current Position: (" + player.position[0] + ", " + player.position[1] + ")");
		
		//changes current area's playerInArea to false
		map.map[player.position[0]][player.position[1]].playerInArea = false;
	}
	
	//function that outputs player's new position AFTER moving and sets new Area's playerInArea to true
	public void afterMoveDisplayUpdate(Player player, Map map) {
		
		//changes new area's playerInArea to true
		map.map[player.position[0]][player.position[1]].playerInArea = true;
		
		//outputs player's new position after moving up
		System.out.print("Player's new Position: (" + player.position[0] + ", " + player.position[1] + ")");
	}
	
	//moves the player 1 Area up on the map
	public boolean moveUp(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at upward boundary
		if (playerAtUpBoundary(player, mapSize)) {
			System.out.print("Player cannot move up.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[1] += 1;
		
		afterMoveDisplayUpdate(player, map);

		return true;
	}
	
	//moves the player 1 Area down on the map
	public boolean moveDown(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at downward boundary
		if (playerAtDownBoundary(player, mapSize)) {
			System.out.println("Player cannot move down.");
			
			return false;
		}

		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[1] -= 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}
	
	//moves the player 1 Area left on the map
	public boolean moveLeft(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at left boundary
		if (playerAtLeftBoundary(player, mapSize)) {
			System.out.println("Player cannot move left.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[0] -= 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}
	
	//moves the player 1 Area right on the map
	public boolean moveRight(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at boundary
		if (playerAtRightBoundary(player, mapSize)) {
			System.out.println("Player cannot move right.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[0] += 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}

	public static void fillMapEnemies(Map map) {
		// TODO Auto-generated method stub
		
	}

	public static void fillMapConsumables(Map map) {
		// TODO Auto-generated method stub
		
	}
	
}
