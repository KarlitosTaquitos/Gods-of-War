
public class Neko extends Therianthrope implements GameElement{
	
	public Neko(int x, int y) {
		this.name = "Neko";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 50;
		this.bd = 20;
		this.STR = 2;
		this.CON = 2;
		this.SPD = 10;
		this.INT = 2;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeNeko(int x, int y){
			Neko newNeko = new Neko(x,y);
			
			return newNeko;
			
		}

}
