
public class Klaus extends Boss implements GameElement{
	
	public Klaus(int x, int y) {
		this.name = "Klaus";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 150;
		this.bd = 30;
		this.STR = 4;
		this.CON = 20;
		this.SPD = 4;
		this.INT = 4;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeKlause(int x, int y){
			Klaus newKlaus = new Klaus(x,y);
			
			return newKlaus;
			
		}

}
