
public class Leo extends Boss implements GameElement{
	
	public Leo(int x, int y) {
		this.name = "Leo";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 150;
		this.bd = 30;
		this.STR = 4;
		this.CON = 4;
		this.SPD = 20;
		this.INT = 4;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeLeo(int x, int y){
			Leo newLeo = new Leo(x,y);
			
			return newLeo;
			
		}

}
