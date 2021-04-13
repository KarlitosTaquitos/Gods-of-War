
public class Emu extends Animals implements GameElement{
	
	public Emu(int x, int y) {
		this.name = "Emu";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 2;
		this.CON = 2;
		this.SPD = 2;
		this.INT = 2;
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeEmu(int x, int y){
		Emu newEmu = new Emu(x,y);
		
		return newEmu;
		
	}

}
