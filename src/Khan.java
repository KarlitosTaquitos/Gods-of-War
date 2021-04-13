
public class Khan extends Boss implements GameElement{
	
	boolean isDefeated;
	
	public Khan(int x, int y) {
		this.name = "Khan";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 150;
		this.bd = 50;
		this.STR = 20;
		this.CON = 4;
		this.SPD = 4;
		this.INT = 4;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeKhan(int x, int y){
			Khan newKhan = new Khan(x,y);
			
			return newKhan;
			
		}

}
