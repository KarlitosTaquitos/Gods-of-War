
public class GodsChosen extends Enemies implements GameElement {
	
	int[] opt1 = new int[] {15,3,3,3};
	int[] opt2 = new int[] {3,15,3,3};
	int[] opt3 = new int[] {3,3,15,3};
	int[] opt4 = new int[] {3,3,3,15};
	
	public GodsChosen(int x, int y) {
		this.name = "God's Chosen";
		this.position[0] = x;
		this.position[1] = y;
		this.hp = 100;
		this.bd = 40;
		
		int rand = (int)(Math.random()*5);
		//System.out.println(rand);
		
		if(rand == 0)
		{
			this.STR = opt1[0];
			this.CON = opt1[1];
			this.SPD = opt1[2];
			this.INT = opt1[3];
			//System.out.println(STR+" "+CON+" "+SPD+" "+INT);
		}
		
		else if(rand==1) {
			this.STR = opt2[0];
			this.CON = opt2[1];
			this.SPD = opt2[2];
			this.INT = opt2[3];
			//System.out.println(STR+" "+CON+" "+SPD+" "+INT);
		}
		
		else if(rand==2) {
			this.STR = opt3[0];
			this.CON = opt3[1];
			this.SPD = opt3[2];
			this.INT = opt3[3];
			//System.out.println(STR+" "+CON+" "+SPD+" "+INT);
		}
		
		else if(rand==3) {
			this.STR = opt3[0];
			this.CON = opt3[1];
			this.SPD = opt3[2];
			this.INT = opt3[3];
			//System.out.println(STR+" "+CON+" "+SPD+" "+INT);
		}
		
		else {
			this.STR = opt4[0];
			this.CON = opt4[1];
			this.SPD = opt4[2];
			this.INT = opt4[3];
			//System.out.println(STR+" "+CON+" "+SPD+" "+INT);
		}
		
		this.isDefeated = false;
		
	}
	
	public static Enemies makeGodsChosen(int x, int y){
		GodsChosen newGodsChosen = new GodsChosen(x,y);
			
		return newGodsChosen;
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}