import javax.swing.JLabel;

public class ConsumableBackEnd {

	//function that checks if player has any of given consumable
	public static boolean hasConsumable(Player player, Consumables consumable, JLabel mes_l) {
		
		if (consumable.name == "Food")
		{
			//checks if player has no food
			if (player.food == 0)
			{
				mes_l.setText(mes_l.getText() + "You have no Food to consume.<br/>");
				
				return false;
			}
		}
			
		if (consumable.name == "Small Potion")
		{
			//checks if player has no smPots
			if (player.smPot == 0)
			{
				mes_l.setText(mes_l.getText() + "You have no Small Potions to consume.<br/>");
				
				return false;
			}
		}
		
		if (consumable.name == "Large Potion")
		{
			//checks if player has no food
			if (player.lgPot == 0)
			{
				mes_l.setText(mes_l.getText() + "You have no Large Potions to consume.<br/>");
				
				return false;
			}
		}
		
		//if all else false, then player has at least 1 of consumable
		return true;
	}
	
	//function that conducts operations for player using consumable--------------------------------------------
	public static boolean useConsumable(Player player, Consumables consumable, JLabel mes_l) {
		
		//checks if player has any of consumable type
		if (!hasConsumable(player, consumable, mes_l))
			return false;
		
		//variable representing the player's maximum hit points
		int maxHP = 100;
		
		//checks if player is at max hit points
		
		if (player.hp == maxHP)
		{
			//consumable not used
			mes_l.setText(mes_l.getText() + "You are already at max hit points.<br/>");
			
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
		
		mes_l.setText(mes_l.getText() + "You use " + consumable.name + " and heals " + healing + " hit points!<br/>");
		
		consumeConsumable(player, consumable, mes_l);
		
		return true;
	}

	//decrements the player's held consumables after use
	public static void consumeConsumable(Player player, Consumables consumable, JLabel mes_l) {
		
		if (consumable.name == "Food")
		{
			player.food -= 1;
			
			mes_l.setText(mes_l.getText() + "You have " + player.food + " left.<br/>");
		}
			
		if (consumable.name == "Small Potion")
		{
			player.smPot -= 1;
			
			mes_l.setText(mes_l.getText() + "You have " + player.smPot + " left.<br/>");
		}
		
		if (consumable.name == "Large Potion")
		{
			player.lgPot -= 1;
			
			mes_l.setText(mes_l.getText() + "You have " + player.lgPot + " left.<br/>");
		}
	}
}
