
public class Player {
	
	int[] position = new int[2];
	private int hp; //health points
	private int bd; //base damage
	private int STR; //strength
	private int INT; //intelligence
	private int CON; //constitution
	private int SPD; //speed

	
	public Player() {
		
	this.position[0] =1;
	this.position[1] =1;
	this.hp = 100;
	this.bd = 10;
	this.STR = 10;
	this.INT = 10;
	this.CON = 10;
	this.SPD = 10;
	
	}
	

}
