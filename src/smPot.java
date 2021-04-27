
public class smPot extends Consumables{

	public smPot() {
		this.name = "Small Potion";
		this.healingpower = 50;
	}
	
	public smPot(int x, int y) {
		
		this.xPos = x;
		this.yPos = y;
		
		this.name = "Small Potion";
		this.healingpower = 50;
	}
	
	public static Consumables makeSMPot(int x, int y) {
		Consumables newSMPot = new smPot(x, y);
		
		return newSMPot;
	}
	
	@Override
	public void write(String filename) {
		// TODO Auto-generated method stub
		
	}
}
