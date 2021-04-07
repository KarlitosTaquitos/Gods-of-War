
public class Player implements GameElement{
	
	
	int[] position = new int[2];
	public int hp; //health points
	public int bd; //base damage
	public int STR; //strength
	public int INT; //intelligence
	public int CON; //constitution
	public int SPD; //speed
	public int food;
	public int smPot; //small potion
	public int lgPot; //large potion
	

	
	public Player() {
		
		this.position[0] =1;
		this.position[1] =1;
		this.hp = 100;
		this.bd = 10;
		this.STR = 10;
		this.INT = 10;
		this.CON = 10;
		this.SPD = 10;
		this.food = 0;
		this.smPot = 0;
		this.lgPot = 0;
	
	}



	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	

}
