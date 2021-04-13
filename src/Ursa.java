
public class Ursa extends Boss implements GameElement{
	
	public Ursa(int x, int y) {
		this.name = "Ursa";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 175;
		this.bd = 60;
		this.STR = 8;
		this.CON = 8;
		this.SPD = 8;
		this.INT = 8;
		
		this.isDefeated = false;
		
		}
		
		public static Enemies makeUrsa(int x, int y){
			Ursa newUrsa = new Ursa(x,y);
			
			return newUrsa;
			
		}

}
