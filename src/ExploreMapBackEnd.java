
public class ExploreMapBackEnd {
	
	public boolean moveUp(Player player, Map map) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[1] += 1;
		
		return true;
	}
	
	public boolean moveDown(Player player, Map map) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[1] -= 1;
		
		return true;
	}
	
	public boolean moveLeft(Player player, Map map) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[0] -= 1;
		
		return true;
	}
	
	public boolean moveRight(Player player, Map map) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[0] += 1;
		
		return true;
	}

	public static void fillMapEnemies(Map map) {
		// TODO Auto-generated method stub
		
	}

	public static void fillMapConsumables(Map map) {
		// TODO Auto-generated method stub
		
	}
	
}
