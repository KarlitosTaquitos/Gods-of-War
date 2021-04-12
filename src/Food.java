
public class Food extends Consumables{
	
	public Food() {
		
		this.name = "Food";
		this.healingpower = 25;
	}
	
	public Food(int x, int y) {
		
		this.xPos = x;
		this.yPos = y;
		
		this.name = "Food";
		this.healingpower = 25;
	}
	
	public static Consumables makeFood(int x, int y) {
		Consumables newFood = new Food(x, y);
		
		return newFood;
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}
