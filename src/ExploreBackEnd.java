
public class ExploreBackEnd {

	public boolean moveUp(Player player) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[1] += 1;
		
		return true;
	}
	
	public boolean moveDown(Player player) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[1] -= 1;
		
		return true;
	}
	
	public boolean moveLeft(Player player) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[0] -= 1;
		
		return true;
	}
	
	public boolean moveRight(Player player) {
		
		//checks map size
		
		//checks if player at boundary
		
		//modifies player position
		player.position[0] += 1;
		
		return true;
	}
	
}
