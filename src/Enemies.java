
public class Enemies extends Player implements GameElement {
	
	boolean isDefeated;
	
	//black constructor for subclasses
	public Enemies() {
		
	}

	//null constructor for nullEnemy if needed
	public Enemies(int x, int y) {
		
	}
	
	public static Enemies makeNullEnemy(int x, int y) {
		Enemies nullEnemy = new Enemies(x, y);
		
		return nullEnemy;
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}