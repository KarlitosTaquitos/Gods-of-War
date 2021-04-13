import java.util.Random;
import javax.swing.JLabel;

public class ExploreMapBackEnd {
	
	public static Enemies isThereEnemy(Player player, Map map) {
		
		if (Map.map[player.position[0]][player.position[1]].enemyInArea == true)
		{			
			//change to battle screen
			
			return Map.map[player.position[0]][player.position[1]].areaEnemy;
		}
		
		else return null;
	}
	
	public static String enemyHereMessage(Player player, Map map) {
		return Map.map[player.position[0]][player.position[1]].areaEnemy.name + " encountered!";
	}
	
	
	//function that checks if there is a consumable in area
	public static boolean isThereConsumable(Player player, Map map, JLabel pos_l) {
		
		if (Map.map[player.position[0]][player.position[1]].consumableInArea == true)
		{
			pos_l.setText(pos_l.getText() + "You found a " + Map.map[player.position[0]][player.position[1]].areaConsumbale.name + "!<br/>");
			
			//adds consumable to inventory
			pickUpConsumable(player, Map.map[player.position[0]][player.position[1]].areaConsumbale, pos_l);
			
			//removes consumable from area
			Map.map[player.position[0]][player.position[1]].consumableInArea = false;
			
			return true;
		}
		
		return false;
	}
	
	//increments player's inventory of consumables when a consumable type is found
	private static void pickUpConsumable(Player player, Consumables consumable, JLabel pos_l) {
		
		//checks if consumable is a Food
		if (consumable.name == "Food")
		{
			player.food += 1;
			
			pos_l.setText(pos_l.getText() + "You now have " + player.food + " portions of Food.<br/>");
		}
		
		if (consumable.name == "Small Potion")
		{
			player.smPot += 1;
			
			pos_l.setText(pos_l.getText() + "You now have " + player.smPot + " Small Potions.<br/>");
		}
		
		if (consumable.name == "Large Potion")
		{
			player.lgPot += 1;
			
			pos_l.setText(pos_l.getText() + "You now have " + player.lgPot + " Large Potions.<br/>");
		}
		
	}

	//function that determines if player is at upward map boundary---------
	public static boolean playerAtUpBoundary(Player player, int mapSize, JLabel pos_l) {
		boolean atBoundary = false;
		
		//if player's y position is == to mapSize,
		// they are at the upward boundary
		// (e.g if player position is [1, 6], player is at upward boundary)
		if (player.position[1] == mapSize - 1) {
			atBoundary = true;
			
			pos_l.setText(pos_l.getText() + "You are at upward boundary.<br/>");
			
			return atBoundary;
		}
		
		return atBoundary;
	}

	//function that determines if player is at downward map boundary=
	public static boolean playerAtDownBoundary(Player player, int mapSize, JLabel pos_l) {
		boolean atBoundary = false;
		
		if (player.position[1] == 1) {
			atBoundary = true;
			
			pos_l.setText(pos_l.getText() + "You are at downward boundary.<br/>");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at left boundary---------
	public static boolean playerAtLeftBoundary(Player player, int mapSize, JLabel pos_l) {
		boolean atBoundary = false;
		
		if (player.position[0] == 1) {
			atBoundary = true;
			
			pos_l.setText(pos_l.getText() + "You are at left boundary.<br/>");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that determines if player is at right boundary---------
	public static boolean playerAtRightBoundary(Player player, int mapSize, JLabel pos_l) {
		boolean atBoundary = false;
		
		if (player.position[0] == mapSize - 1) {
			atBoundary = true;
			
			pos_l.setText(pos_l.getText() + "You are at right boundary.<br/>");
			
			return atBoundary;
		}
		
		return atBoundary;
	}
	
	//function that outputs player's current position BEFORE moving and sets current Area's playerInArea to false
	public static void beforeMoveDisplayUpdate(Player player, Map map, JLabel pos_l) {

		//outputs player's current position before moving up
		pos_l.setText(pos_l.getText() + "Last Position: (" + player.position[0] + ", " + player.position[1] + ")<br/>");
		
		//changes current area's playerInArea to false
		Map.map[player.position[0]][player.position[1]].playerInArea = false;
	}
	
	//function that outputs player's new position AFTER moving and sets new Area's playerInArea to true------
	public static void afterMoveDisplayUpdate(Player player, Map map, JLabel pos_l) {
		
		//changes new area's playerInArea to true
		Map.map[player.position[0]][player.position[1]].playerInArea = true;
		
		//outputs player's new position after moving up
		pos_l.setText(pos_l.getText() + "Current Position: (" + player.position[0] + ", " + player.position[1] + ")<br/>");
		
		//checks if there's a consumable
		isThereConsumable(player, map, pos_l);
		isThereEnemy(player, map);
	}

	//moves the player 1 Area up on the map------------
	public static boolean moveUp(Player player, Map map, JLabel pos_l) {
		
		int mapSize = map.size;
		
		//checks if player at upward boundary
		if (playerAtUpBoundary(player, mapSize, pos_l)) {			
			pos_l.setText(pos_l.getText() + "Cannot move up.<br/>");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map, pos_l);
		
		//modifies player position
		player.position[1] += 1;
		
		afterMoveDisplayUpdate(player, map, pos_l);

		return true;
	}
	
	//moves the player 1 Area down on the map--------------
	public static boolean moveDown(Player player, Map map, JLabel pos_l) {
		
		int mapSize = map.size;
		
		//checks if player at downward boundary
		if (playerAtDownBoundary(player, mapSize, pos_l)) {
			pos_l.setText(pos_l.getText() + "Cannot move down.<br/>");
			
			return false;
		}

		beforeMoveDisplayUpdate(player, map, pos_l);
		
		//modifies player position
		player.position[1] -= 1;
		
		afterMoveDisplayUpdate(player, map, pos_l);
		
		return true;
	}
	
	//moves the player 1 Area left on the map--------------
	public static boolean moveLeft(Player player, Map map, JLabel pos_l) {
		
		int mapSize = map.size;
		
		//checks if player at left boundary
		if (playerAtLeftBoundary(player, mapSize, pos_l)) {
			pos_l.setText(pos_l.getText() + "Cannot move left.<br/>");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map, pos_l);
		
		//modifies player position
		player.position[0] -= 1;
		
		afterMoveDisplayUpdate(player, map, pos_l);
		
		return true;
	}
	
	//moves the player 1 Area right on the map--------------
	public static boolean moveRight(Player player, Map map, JLabel pos_l) {
		
		int mapSize = map.size;
		
		//checks if player at boundary
		if (playerAtRightBoundary(player, mapSize, pos_l)) {
			pos_l.setText(pos_l.getText() + "Cannot move right.<br/>");
			
			return false;
		}
		
		beforeMoveDisplayUpdate(player, map, pos_l);
		
		//modifies player position
		player.position[0] += 1;
		
		afterMoveDisplayUpdate(player, map, pos_l);
		
		return true;
	}

	//function that fills map with enemies in random Areas
	public static boolean fillMapEnemies(Map map) {
		
		Random rand = new Random();
		
		for (int i = 0; i < map.size - 1; i++)
		{
			//lower leveled monsters
			int randIntX = rand.nextInt(map.size);
			int randIntY = rand.nextInt(map.size);
			
			if (Map.map[randIntX][randIntY].enemyInArea == false) {
				Map.map[randIntX][randIntY].areaEnemy = Boar.makeBoar(randIntX, randIntY);
				
				Map.map[randIntX][randIntY].enemyInArea = true;
			}
			
			//higher leveled monsters
			randIntX = rand.nextInt(map.size);
			randIntY = rand.nextInt(map.size);
			
			while (randIntX <= map.size / 2 || randIntY <= map.size / 2) {
				randIntX = rand.nextInt(map.size);
				randIntY = rand.nextInt(map.size);
			}
			
			//make stronger monster
			
			//God's Chosen random placement
		}
		
		return true;
	}

	//function that fills map with consumables in random Areas
	public static boolean fillMapConsumables(Map map) {
		
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
