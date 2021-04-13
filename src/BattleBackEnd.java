import java.util.Random;

public class BattleBackEnd {

	//booleans that dictate which turn it is
	static boolean playerTurn;
	static boolean enemyTurn;
	
	//function that calculates whether the player misses their attack
	// if true, player misses
	// if false, player hits
	public static boolean playerMisses(Player player, Enemies enemy) {
		
		//modifiers to accuracy and dodge chance
		int accMod = 3;
		int dodMod = 9;
		
		//accuracy and dodge calculation
		int playerAcc = 100 + accMod * player.SPD;
		int enemyDod = 100 + dodMod * enemy.SPD;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(enemyDod);
		
		if (randInt <= playerAcc) {
			System.out.println("You hit!");
			
			return true;
		}
		
		else {
			System.out.println("You missed!");
			
			return false;
		}
	}
	
	//function that calculates whether the enemy misses their attack
	// if true, enemy misses
	// if false, enemy hits
	public boolean enemyMisses(Enemies enemy, Player player) {
		
		//modifiers to accuracy and dodge chance
		int accMod = 3;
		int dodMod = 9;
		
		//accuracy and dodge calculation
		int enemyAcc = 100 + accMod * enemy.SPD;
		int playerDod = 100 + dodMod * player.SPD;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(playerDod);
		
		if (randInt <= enemyAcc) {
			System.out.println("The" + enemy.name + " hit!");
			
			return true;
		}
		
		else {
			System.out.println("The" + enemy.name + " missed!");
			
			return false;
		}
	}
	
	//function that determines if the player's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public static boolean playerCrit(Player player) {
		
		//modifier to crit chance
		int critMod = 3;
		
		//crit chance calculation
		int critChan = player.INT * critMod;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(100);
		
		if (randInt <= critChan) {
			System.out.println("You landed a critical hit!");
			
			return true;
		}
		
		else return false;
	}
	
	//function that determines if the enemy's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public boolean enemyCrit(Enemies enemy) {
		
		//modifier to crit chance
		int critMod = 3;
		
		//crit chance calculation
		int critChan = enemy.INT * critMod;
		
		Random rand = new Random();
		
		int randInt = rand.nextInt(100);
		
		if (randInt <= critChan) {
			System.out.println(enemy.name + " landed a critical hit!");
			
			return true;
		}
				
		else return false;
	}
	
	//function that calculates player's attack damage
	public static int playerDMG(Player player, Enemies enemy) {
		
		//modifiers to calculated damage
		int ATKMod = 1;
		int DEFMod = 2;
		
		//checks if attack was a critical hit
		if (playerCrit(player)) {
			ATKMod = 2;
		}
		
		//calculates damage dealt
		int dmgDealt = player.bd + (player.STR * ATKMod) - enemy.CON * DEFMod; 
		
		return dmgDealt;
	}
	
	//function that calculates enemy's attack damage
	public int enemyDMG(Enemies enemy, Player player) {
		//checks if attack was a critical hit
		
		//modifiers to calculated damage
		int ATKMod = 1;
		int DEFMod = 2;
		
		//calculates damage dealt
		int dmgDealt = enemy.bd + (enemy.STR * ATKMod) - player.CON * DEFMod;
		
		return dmgDealt;
	}
	
	//function that conducts operations for player attacking an enemy------------------
	public static void attack(Player player, Enemies enemy) {
		
		//checks if enemy is already defeated
		//no attack conducted in this case
		//this is largely for testing while game doesn't return to explore screen
		// after defeating an enemy
		//when an enemy is defeated, game should return to explore screen
		if (enemy.isDefeated == true) {
			System.out.println("Enemy was defeated.");
			
			return;
		}
		
		System.out.println("You attack the " + enemy.name + "!");
		
		//determines if attack hits or misses
		if (!playerMisses(player, enemy)) {
			return;
		}
		
		//determines attack damage
		int dmg = playerDMG(player, enemy);
		
		//subtracts damage from enemy hit points
		enemy.hp -= dmg;
		
		System.out.println("You deal " + dmg + " damage to " + enemy.name);
		
		//checks if enemy is defeated
		if (isDefeated(enemy)) {
			Map.map[player.position[0]][player.position[1]].enemyInArea = false;
			
			player.APpool += 1;
			
			System.out.println("You gained 1 AP!");
			System.out.println("You have " + player.APpool + " unspent AP.");
			
			//return to explore map
		
		}
		
		return;
	}
	
	//function that determines whether an enemy is defeated
	private static boolean isDefeated(Enemies enemy) {
		if (enemy.hp <= 0) {
			enemy.isDefeated = true;
			
			System.out.println(enemy.name + " was defeated!");
			
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
	public void enemyAttack(Enemies enemy, Player player) {
		
		//determines if attack hits or misses
		if (!enemyMisses(enemy, player)) {
			return;
		}
		
		//determines damage
		int dmg = enemyDMG(enemy, player);
		
		//subtracts damage from player hit points
		player.hp -= dmg;
		
		System.out.println(enemy.name + " deals " + dmg + " damage to " + player.name);
		
		//checks if player is defeated
		if (playerDefeated(player)) {
			
			//return to last rest area
			
		}
	}

	private boolean playerDefeated(Player player) {
		if (player.hp <= 0) {
			return true;
		}
		
		else return false;
	}
	
}
