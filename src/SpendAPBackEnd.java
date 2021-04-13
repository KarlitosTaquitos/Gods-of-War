import javax.swing.JLabel;

public class SpendAPBackEnd {

	//These functions increase the various Attributes of the player,
	// first checking if the player has any AP to spend
	//
	//The player must have at least 1 AP to spend to increase an Attribute
	
	//Spend AP on STR--------------------------------------------------
	public static boolean increaseSTR(Player player, JLabel mes_l) {
		if (player.APpool == 0) {
			mes_l.setText(mes_l.getText() + "You have no AP to spend.<br/>");
			
			return false;
		}
		
		player.STR += 1;
		player.APpool -= 1;
		
		mes_l.setText(mes_l.getText() + "Your STR was increased by 1!<br/>");
		
		//updates Boss to player's new AP distribution
		EnemiesBackEnd.updateBoss(player, GamePlay.map);
		
		return true;
	}
	
	//Spend AP on INT--------------------------------------------------
	public static boolean increaseINT(Player player, JLabel mes_l) {
		if (player.APpool == 0) {
			mes_l.setText(mes_l.getText() + "You have no AP to spend.<br/>");
			
			return false;
		}
		
		player.INT += 1;
		player.APpool -= 1;
		
		mes_l.setText(mes_l.getText() + "Your INT was increased by 1!<br/>");
		
		//updates Boss to player's new AP distribution
		EnemiesBackEnd.updateBoss(player, GamePlay.map);
		
		return true;
	}
	
	//Spend AP on CON--------------------------------------------------
	public static boolean increaseCON(Player player, JLabel mes_l) {
		if (player.APpool == 0) {
			mes_l.setText(mes_l.getText() + "You have no AP to spend.<br/>");
			
			return false;
		}
		
		player.CON += 1;
		player.APpool -= 1;
		
		mes_l.setText(mes_l.getText() + "Your CON was increased by 1!<br/>");
		
		//updates Boss to player's new AP distribution
		EnemiesBackEnd.updateBoss(player, GamePlay.map);
		
		return true;
	}
	
	//Spend AP on SPD--------------------------------------------------
	public static boolean increaseSPD(Player player, JLabel mes_l) {
		if (player.APpool == 0) {
			mes_l.setText(mes_l.getText() + "You have no AP to spend.<br/>");
			
			return false;
		}
		
		player.SPD += 1;
		player.APpool -= 1;
		
		mes_l.setText(mes_l.getText() + "Your SPD was increased by 1!<br/>");
		
		//updates Boss to player's new AP distribution
		EnemiesBackEnd.updateBoss(player, GamePlay.map);
		
		return true;
	}
	
}
