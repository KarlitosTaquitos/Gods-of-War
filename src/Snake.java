
public class Snake extends Animals implements GameElement{
	
	public Snake(int x, int y) {
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 1;
		this.CON = 1;
		this.SPD = 5;
		this.INT = 1;
		
	}

}
