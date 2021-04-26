
public class Area{
	
	//variables that represent the Area's location on the map
	// x, y
	int xPos;
	int yPos;
	
	//boolean whether player is in the Area
	boolean playerInArea;
	
	//boolean whether an enemy is in the Area
	boolean enemyInArea;
	//stores the enemy, if there is one in the area
	Enemies areaEnemy;
	
	//boolean whether a consumable is in the Area
	boolean consumableInArea;
	//stores the consumable, if there is one in the area
	Consumables areaConsumbale;
	 
	//boolean representing whether the area is a rest area
	boolean isRestArea;

	//boolean representing whether this area has been discovered yet
	boolean discovered;
	
	//base constructor for Area with no player, enemy, or consumable
	// and not being a Rest Area
	public Area(int xPosition, int yPosition) {
		this.xPos = xPosition;
		this.yPos = yPosition;
		
		this.playerInArea = false;
		this.enemyInArea = false;
		this.consumableInArea = false;
		this.isRestArea = false;
	}
	
	//Don't believe we need these here. Better called by Map class and implemented in ExploreMapBackEnd
	//public void addEnemies(Map size) {
	//	Enemies.add(e);
	//}
	
	//public void addConsumables(Map size) {
	//	Consumables.add(e);
	//}
	
	//public void addRestArea(RestArea e) {
	//	RestArea.add(e);
	//}

}
