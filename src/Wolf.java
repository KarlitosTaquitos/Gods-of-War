
public class Wolf extends Animals implements GameElement{
	
	public Wolf(int x, int y) {
		this.name = "Wolf";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 25;
		this.bd = 10;
		this.STR = 1;
		this.CON = 1;
		this.SPD = 1;
		this.INT = 5;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeWolf(int x, int y){
			Wolf newWolf = new Wolf(x,y);
			
			return newWolf;
			
		}

}
