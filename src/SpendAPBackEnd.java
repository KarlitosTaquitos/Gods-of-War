
public class SpendAPBackEnd {

	//These functions increase the various Attributes of the player,
	// first checking if the player has any AP to spend
	//
	//The player must have at least 1 AP to spend to increase an Attribute
	
	//Spend AP on STR--------------------------------------------------
	public boolean increaseSTR(Player player) {
		if (player.APpool == 0) {
			System.out.println("No AP to spend.");
			
			return false;
		}
		
		player.STR += 1;
		player.APpool -= 1;
		
		System.out.println(player.name + "'s STR was increased by 1!");
		
		return true;
	}
	
	//Spend AP on INT--------------------------------------------------
	public boolean increaseINT(Player player) {
		if (player.APpool == 0) {
			System.out.println("No AP to spend.");
			
			return false;
		}
		
		player.INT += 1;
		player.APpool -= 1;
		
		System.out.println(player.name + "'s INT was increased by 1!");
		
		return true;
	}
	
	//Spend AP on CON--------------------------------------------------
	public boolean increaseCON(Player player) {
		if (player.APpool == 0) {
			System.out.println("No AP to spend.");
			
			return false;
		}
		
		player.CON += 1;
		player.APpool -= 1;
		
		System.out.println(player.name + "'s CON was increased by 1!");
		
		return true;
	}
	
	//Spend AP on SPD--------------------------------------------------
	public boolean increaseSPD(Player player) {
		if (player.APpool == 0) {
			System.out.println("No AP to spend.");
			
			return false;
		}
		
		player.SPD += 1;
		player.APpool -= 1;
		
		System.out.println(player.name + "'s SPD was increased by 1!");
		
		return true;
	}
	
}
