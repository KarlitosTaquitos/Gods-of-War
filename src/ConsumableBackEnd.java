
public class ConsumableBackEnd {

	//function that checks if player has any of given consumable
	public static boolean hasConsumable(Player player, Consumables consumable) {
		
		if (consumable.name == "Food")
		{
			//checks if player has no food
			if (player.food == 0)
			{
				System.out.println(player.name + " has no Food to consume.");
				
				return false;
			}
		}
			
		if (consumable.name == "Small Potion")
		{
			//checks if player has no smPots
			if (player.smPot == 0)
			{
				System.out.println(player.name + " has no Small Potions to consume.");
				
				return false;
			}
		}
		
		if (consumable.name == "Large Potion")
		{
			//checks if player has no food
			if (player.lgPot == 0)
			{
				System.out.println(player.name + " has no Large Potions to consume.");
				
				return false;
			}
		}
		
		//if all else false, then player has at least 1 of consumable
		return true;
	}
	
	//function that conducts operations for player using consumable--------------------------------------------
	public static boolean useConsumable(Player player, Consumables consumable) {
		
		//checks if player has any of consumable type
		if (!hasConsumable(player, consumable))
			return false;
		
		//variable representing the player's maximum hit points
		int maxHP = 100;
		
		//checks if player is at max hit points
		
		if (player.hp == maxHP)
		{
			//consumable not used
			System.out.println(player.name + " is already at max hit points.");
			
			return false;
		}
		
		//determines healing
		int healing = consumable.healingpower;
		
		//checks if consumable would put player above max hit points
		if (player.hp + healing > maxHP)
		{
			int hpDiff = maxHP - player.hp;
			
			healing = hpDiff;
		}
		
		//adds healing to player hit points
		player.hp += healing;
		
		System.out.println(player.name + " uses " + consumable.name + " and heals " + healing + " hit points!");
		
		consumeConsumable(player, consumable);
		
		return true;
	}

	//decrements the player's held consumables after use
	public static void consumeConsumable(Player player, Consumables consumable) {
		
		if (consumable.name == "Food")
		{
			player.food -= 1;
			
			System.out.println(player.name + " has " + player.food + " left.");
		}
			
		if (consumable.name == "Small Potion")
		{
			player.smPot -= 1;
			
			System.out.println(player.name + " has " + player.smPot + " left.");
		}
		
		if (consumable.name == "Large Potion")
		{
			player.lgPot -= 1;
			
			System.out.println(player.name + " has " + player.lgPot + " left.");
		}
	}
}
