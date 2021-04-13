import java.util.Random;

import javax.swing.JLabel;

public class BattleBackEnd {

	//booleans that dictate which turn it is
	static boolean playerTurn;
	static boolean enemyTurn;
	
	//function that calculates whether the player misses their attack
	// if true, player misses
	// if false, player hits
	public static boolean playerMisses(Player player, Enemies enemy, JLabel mes_l) {
		
		//modifiers to accuracy and dodge chance
		int accMod = 3;
		int dodMod = 9;
		
		//accuracy and dodge calculation
		int playerAcc = 100 + accMod * player.SPD;
		int enemyDod = 100 + dodMod * enemy.SPD;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(enemyDod);
		
		if (randInt <= playerAcc) {
			mes_l.setText(mes_l.getText() + "You hit!<br/>");
			
			return true;
		}
		
		else {
			mes_l.setText(mes_l.getText() + "You missed!<br/>");
			
			return false;
		}
	}
	
	//function that calculates whether the enemy misses their attack
	// if true, enemy misses
	// if false, enemy hits
	public static boolean enemyMisses(Enemies enemy, Player player, JLabel mes_l) {
		
		//modifiers to accuracy and dodge chance
		int accMod = 3;
		int dodMod = 9;
		
		//accuracy and dodge calculation
		int enemyAcc = 100 + accMod * enemy.SPD;
		int playerDod = 100 + dodMod * player.SPD;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(playerDod);
		
		if (randInt <= enemyAcc) {
			mes_l.setText(mes_l.getText() + "The" + enemy.name + " hit!<br/>");
			
			return true;
		}
		
		else {
			mes_l.setText(mes_l.getText() + "The" + enemy.name + " missed!<br/>");
			
			return false;
		}
	}
	
	//function that determines if the player's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public static boolean playerCrit(Player player, JLabel mes_l) {
		
		//modifier to crit chance
		int critMod = 3;
		
		//crit chance calculation
		int critChan = player.INT * critMod;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(100);
		
		if (randInt <= critChan) {
			mes_l.setText(mes_l.getText() + "You landed a critical hit!<br/>");
			
			return true;
		}
		
		else return false;
	}
	
	//function that determines if the enemy's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public boolean enemyCrit(Enemies enemy, JLabel mes_l) {
		
		//modifier to crit chance
		int critMod = 3;
		
		//crit chance calculation
		int critChan = enemy.INT * critMod;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(100);
		
		if (randInt <= critChan) {
			mes_l.setText(mes_l.getText() + enemy.name + " landed a critical hit!<br/>");
			
			return true;
		}
				
		else return false;
	}
	
	//function that calculates player's attack damage
	public static int playerDMG(Player player, Enemies enemy, JLabel mes_l) {
		
		//modifiers to calculated damage
		int ATKMod = 1;
		int DEFMod = 2;
		
		//checks if attack was a critical hit
		if (playerCrit(player, mes_l)) {
			ATKMod = 2;
		}
		
		//calculates damage dealt
		int dmgDealt = player.bd + (player.STR * ATKMod) - enemy.CON * DEFMod; 
		
		return dmgDealt;
	}
	
	//function that calculates enemy's attack damage
	public static int enemyDMG(Enemies enemy, Player player) {
		//checks if attack was a critical hit
		
		//modifiers to calculated damage
		int ATKMod = 1;
		int DEFMod = 2;
		
		//calculates damage dealt
		int dmgDealt = enemy.bd + (enemy.STR * ATKMod) - player.CON * DEFMod;
		
		return dmgDealt;
	}
	
	//function that conducts operations for player attacking an enemy------------------
	public static boolean attack(Player player, Enemies enemy, JLabel mes_l) {
		//will return true if the battle is over and false if not
		
		//checks if enemy is already defeated
		//no attack conducted in this case
		//this is largely for testing while game doesn't return to explore screen
		// after defeating an enemy
		//when an enemy is defeated, game should return to explore screen
		if (enemy.isDefeated == true) {
			mes_l.setText(mes_l.getText() + "Enemy was defeated.<br/>");
			
			return true;
		}
		
		mes_l.setText(mes_l.getText() + "You attack the " + enemy.name + "!<br/>");
		
		//determines if attack hits or misses
		if (!playerMisses(player, enemy, mes_l)) {
			return false;
		}
		
		//determines attack damage
		int dmg = playerDMG(player, enemy, mes_l);
		
		//subtracts damage from enemy hit points
		enemy.hp -= dmg;
		
		mes_l.setText(mes_l.getText() + "You deal " + dmg + " damage to " + enemy.name + "<br/>");
		
		//checks if enemy is defeated
		if (isDefeated(enemy, mes_l)) {
			Map.map[player.position[0]][player.position[1]].enemyInArea = false;
			
			player.APpool += 1;
			
			mes_l.setText(mes_l.getText() + "You gained 1 AP!<br/>");
			mes_l.setText(mes_l.getText() + "You have " + player.APpool + " unspent AP.<br/>");
			
			//return to explore map
			return true;
		}
		
		return false;
	}
	
	//function that determines whether an enemy is defeated
	private static boolean isDefeated(Enemies enemy, JLabel mes_l) {
		if (enemy.hp <= 0) {
			enemy.isDefeated = true;
			
			mes_l.setText(mes_l.getText() + enemy.name + " was defeated!<br/>");
			
			return true;
		}
		
		else return false;
		
	}

	//function that conducts operations for player fleeing combat
	public static String flee(Player player) {
		playerTurn = false;
		enemyTurn = false;
		
		String message = "You fled!<br/>";
		
		return message;
	}
	
	//function that conducts operations for enemy attacking the player-----------------
	public static boolean enemyAttack(Enemies enemy, Player player, JLabel mes_l) {
		//returns true if battle is over
		
		//determines if attack hits or misses
		if (!enemyMisses(enemy, player, mes_l)) {
			return false;
		}
		
		//determines damage
		int dmg = enemyDMG(enemy, player);
		
		//subtracts damage from player hit points
		player.hp -= dmg;
		
		mes_l.setText(mes_l.getText() + enemy.name + " deals " + dmg + " damage to you!<br/>");
		
		//checks if player is defeated
		if (playerDefeated(player)) {
			
			//return to last rest area
			return true;
		}
		
		return false;
	}

	private static boolean playerDefeated(Player player) {
		if (player.hp <= 0) {
			return true;
		}
		
		else return false;
	}
	
}
