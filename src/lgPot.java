
public class lgPot extends Consumables{
	
	public lgPot() {
		
		this.name = "Large Potion";
		this.healingpower = 75;
	}
	
	public lgPot(int x, int y) {
		
		this.xPos = x;
		this.yPos = y;
		
		this.name = "Large Potion";
		this.healingpower = 75;
	}

	public static Consumables makeLGPot(int x, int y) {
		Consumables newLGPot = new lgPot(x, y);
		
		return newLGPot;
	}		
	
	@Override
	public void write(String filename) {
		// TODO Auto-generated method stub
		
	}

}
