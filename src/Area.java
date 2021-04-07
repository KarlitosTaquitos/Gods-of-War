
public class Area{
	 final int xPos,yPos;
	    public Area(int xPosition, int yPosition) {
	        xPos = xPosition;
	        yPos = yPosition;
	    }
	    
	    public void addEnemies(Enemies e) {
	    	Enemies.add(e);
	    }
	    
	    public void addConsumables(Consumables e) {
	    	Consumables.add(e);
	    }
	    
	    public void addRestArea(RestArea e) {
	    	RestArea.add(e);
	    }

}
