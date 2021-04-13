
public class Canid extends Therianthrope implements GameElement{	
	
	public Canid(int x, int y) {
		this.name = "Canid";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 50;
		this.bd = 20;
		this.STR = 4;
		this.CON = 4;
		this.SPD = 4;
		this.INT = 4;
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeCanid(int x, int y){
		Canid newCanid = new Canid(x,y);
		
		return newCanid;
		
	}

}
