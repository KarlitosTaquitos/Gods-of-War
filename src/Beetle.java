
public class Beetle extends Animals implements GameElement{
	
	public Beetle(int x, int y) {
		this.name = "Beetle";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 1;
		this.CON = 5;
		this.SPD = 1;
		this.INT = 1;
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeBeetle(int x, int y){
		Beetle newBeetle = new Beetle(x,y);
		
		return newBeetle;
		
	}
	
}
