
public class Beetle extends Animals implements GameElement{
	
	public Beetle(int x, int y) {
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 1;
		this.CON = 5;
		this.SPD = 1;
		this.INT = 1;
		
	}

}
