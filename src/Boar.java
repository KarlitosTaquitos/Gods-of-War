
public class Boar extends Animals implements GameElement{
	
	public Boar(int x, int y) {
		this.name = "Boar";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 5;
		this.CON = 1;
		this.SPD = 1;
		this.INT = 1;
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeBoar(int x, int y){
		Boar newBoar = new Boar(x,y);
		
		return newBoar;
		
	}
	

}
