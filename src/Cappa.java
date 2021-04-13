
public class Cappa extends Therianthrope implements GameElement{	
	
	public Cappa(int x, int y) {
		this.name = "Cappa";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 50;
		this.bd = 20;
		this.STR = 2;
		this.CON = 2;
		this.SPD = 2;
		this.INT = 10;
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeCappa(int x, int y){
		Cappa newCappa = new Cappa(x,y);
		
		return newCappa;
		
	}

}
