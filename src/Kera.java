
public class Kera extends Therianthrope implements GameElement{
	
	public Kera(int x, int y) {
		this.name = "Kera";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 50;
		this.bd = 20;
		this.STR = 10;
		this.CON = 2;
		this.SPD = 2;
		this.INT = 2;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeKera(int x, int y){
			Kera newKera = new Kera(x,y);
			
			return newKera;
			
		}

}
