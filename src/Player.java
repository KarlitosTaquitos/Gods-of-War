
public class Player implements GameElement {
	
	int[] position = new int[2];
	
	int hp;
	int bd;
	int APpool;
	int STR;
	int INT;
	int CON;
	int SPD;
	int food;
	int smPot;
	int lgPot;
	
	public Player() {
	
		this.position[0] = 1;
		this.position[1] = 1;
		this.APpool = 0;
		this.hp = 100;
		this.bd = 5;
		this.STR = 5;
		this.INT = 5;
		this.CON = 5;
		this.SPD = 5;
		this.food = 0;
		this.smPot = 0;
		this.lgPot = 0;
	
	}
	
	public void write() {
		// TODO
	}

}
