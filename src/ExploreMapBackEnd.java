import java.util.Random;

public class ExploreMapBackEnd {
	
	//function that checks if there is a consumable in area
	public static boolean isThereConsumable(Player player, Map map) {
		
		if (Map.map[player.position[0]][player.position[1]].consumableInArea == true)
		{
			System.out.println(player.name + " found a " + Map.map[player.position[0]][player.position[1]].areaConsumbale.name + "!");
			
			//adds consumable to inventory
			pickUpConsumable(player, Map.map[player.position[0]][player.position[1]].areaConsumbale);
			
			//removes consumable from area
			Map.map[player.position[0]][player.position[1]].consumableInArea = false;
			
			return true;
		}
		
		return false;
	}
	
	//increments player's inventory of consumables when a consumable type is found
	private static void pickUpConsumable(Player player, Consumables consumable) {
		
		//checks if consumable is a Food
		if (consumable.name == "Food")
		{
			player.food += 1;
			
			System.out.println(player.name + " now has " + player.food + " portions of Food.");
		}
		
		if (consumable.name == "Small Potion")
		{
			player.smPot += 1;
			
			System.out.println(player.name + " now has " + player.smPot + " Small Potions.");
		}
		
		if (consumable.name == "Large Potion")
		{
			player.lgPot += 1;
			
			System.out.println(player.name + " now has " + player.lgPot + " Large Potions.");
		}
		
	}

	//function that determines if player is at upward map boundary---------
	public static boolean playerAtUpBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		//if player's y position is == to mapSize,
		// they are at the upward boundary
		// (e.g if player position is [1, 6], player is at upward boundary)
		if (player.position[1] == mapSize - 1) {
			atBoundary = true;
			
			System.out.println(player.name + " is at upward boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}

	//function that determines if player is at downward map boundary=
	public static boolean playerAtDownBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[1] == 1) {
			atBoundary = true;
			
			System.out.println(player.name + " is at downward boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at left boundary---------
	public static boolean playerAtLeftBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[0] == 1) {
			atBoundary = true;
			
			System.out.println(player.name + " is at left boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at right boundary---------
	public static boolean playerAtRightBoundary(Player player, int mapSize) {
		boolean atBoundary = false;
		
		if (player.position[0] == mapSize - 1) {
			atBoundary = true;
			
			System.out.println(player.name + " is at right boundary.");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that outputs player's current position BEFORE moving and sets current Area's playerInArea to false
	public static void beforeMoveDisplayUpdate(Player player, Map map) {

		//outputs player's current position before moving up
		System.out.println(player.name + "'s current Position: (" + player.position[0] + ", " + player.position[1] + ")");
		
		//changes current area's playerInArea to false
		Map.map[player.position[0]][player.position[1]].playerInArea = false;
	}
	
	//function that outputs player's new position AFTER moving and sets new Area's playerInArea to true------
	public static void afterMoveDisplayUpdate(Player player, Map map) {
		
		//changes new area's playerInArea to true
		Map.map[player.position[0]][player.position[1]].playerInArea = true;
		
		//outputs player's new position after moving up
		System.out.println(player.name + "'s new Position: (" + player.position[0] + ", " + player.position[1] + ")");
		
		//checks if there's a consumable
		isThereConsumable(player, map);
	}
	
	//moves the player 1 Area up on the map------------
	public static boolean moveUp(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at upward boundary
		if (playerAtUpBoundary(player, mapSize)) {
			System.out.println(player.name + " cannot move up.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[1] += 1;
		
		afterMoveDisplayUpdate(player, map);

		return true;
	}
	
	//moves the player 1 Area down on the map--------------
	public static boolean moveDown(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at downward boundary
		if (playerAtDownBoundary(player, mapSize)) {
			System.out.println(player.name + " cannot move down.");
			
			return false;
		}

		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[1] -= 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}
	
	//moves the player 1 Area left on the map--------------
	public static boolean moveLeft(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at left boundary
		if (playerAtLeftBoundary(player, mapSize)) {
			System.out.println(player.name + " cannot move left.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[0] -= 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}
	
	//moves the player 1 Area right on the map--------------
	public static boolean moveRight(Player player, Map map) {
		
		int mapSize = map.size;
		
		//checks if player at boundary
		if (playerAtRightBoundary(player, mapSize)) {
			System.out.println(player.name + " cannot move right.");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map);
		
		//modifies player position
		player.position[0] += 1;
		
		afterMoveDisplayUpdate(player, map);
		
		return true;
	}

	//function that fills map with enemies in random Areas
	public static boolean fillMapEnemies(Map map) {
		// TODO
		Random rand = new Random();
		
		for (int i = 0; i < map.size - 1; i++)
		{
			int randIntX = rand.nextInt(map.size);
			int randIntY = rand.nextInt(map.size);
			
			Map.map[randIntX][randIntY].areaEnemy = Boar.makeBoar(randIntX, randIntY);
			Map.map[randIntX][randIntY].enemyInArea = true;
		}
		
		return true;
	}

	//function that fills map with consumables in random Areas
	public static boolean fillMapConsumables(Map map) {
		// TODO
		Random rand = new Random();
		
		//loop that populates map with consumables
		for (int i = 0; i < map.size/2; i++)
		{
			int randIntX = rand.nextInt(map.size);
			int randIntY = rand.nextInt(map.size);
			
			//first populates map with food
			if (Map.map[randIntX][randIntY].consumableInArea == false) {
				Map.map[randIntX][randIntY].areaConsumbale = Food.makeFood(randIntX, randIntY);
				
				Map.map[randIntX][randIntY].consumableInArea = true;
			}
			
			randIntX = rand.nextInt(map.size);
			randIntY = rand.nextInt(map.size);
			
			//then populates map with small potions
			if (Map.map[randIntX][randIntY].consumableInArea == false) {
				Map.map[randIntX][randIntY].areaConsumbale = smPot.makeSMPot(randIntX, randIntY);
				
				Map.map[randIntX][randIntY].consumableInArea = true;
			}
			
			randIntX = rand.nextInt(map.size);
			randIntY = rand.nextInt(map.size);
			
			//lastly, populates map with large potions
			if (Map.map[randIntX][randIntY].consumableInArea == false) {
				Map.map[randIntX][randIntY].areaConsumbale = lgPot.makeLGPot(randIntX, randIntY);
				
				Map.map[randIntX][randIntY].consumableInArea = true;
			}
		}
		
		return true;
	}
	
	//function that fills map with Rest Areas in random Areas
	public static boolean fillMapRestAreas(Map map) {
		// TODO
		
		return true;
	}
	
}
