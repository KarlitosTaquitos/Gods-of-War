import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GodsChosen extends Player implements GameElement {
	
	public void randomIndex() {
		List<Integer> list = new ArrayList<>();
		
		list.add(15);
		list.add(3);
		list.add(3);
		list.add(3);
		
		GodsChosen obj = new GodsChosen();
		
	}
	
	public int getRandom(List<Integer> list)
	{
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
	
	public GodsChosen(int x, int y) {
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 100;
		this.bd = 40;
		this.STR = 
		this.CON = 
		this.SPD =
		this.INT =
		
	}
	




	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}