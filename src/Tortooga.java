
public class Tortooga extends Therianthrope implements GameElement{
	
	public Tortooga(int x, int y) {
		this.name = "Tortooga";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 50;
		this.bd = 20;
		this.STR = 2;
		this.CON = 10;
		this.SPD = 2;
		this.INT = 2;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeTortooga(int x, int y){
			Tortooga newTortooga = new Tortooga(x,y);
			
			return newTortooga;
			
		}

}
