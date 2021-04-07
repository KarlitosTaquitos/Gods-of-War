
public class Stats {
	public int hp; //health points
	public int bd; //base damage
	public int STR; //Strength
	public int INT; //Intellect
	public int CON; //Constitution
	public int SPD; //Speed
	
	public Stats() {
		this(other.hp, other.bd, other.STR, other.INT, other.CON, other.SPD);
	}
	
	public Stats(int hp, int bd, int STR, int INT, int CON, int SPD) {
		this.hp = hp;
		this.bd = bd;
		this.STR = STR;
		this.INT = INT;
		this.CON = CON;
		this.SPD = SPD;
	}

}
