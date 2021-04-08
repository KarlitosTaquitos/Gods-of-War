
public class BattleBackEnd {

	//booleans that dictate which turn it is
	boolean playerTurn;
	boolean enemyTurn;
	
	//function that calculates whether the player misses their attack
	// if true, player misses
	// if false, player hits
	public boolean playerMisses(Player player, Enemies enemy) {
		
		
		return true;
	}
	
	//function that calculates whether the enemy misses their attack
	// if true, enemy misses
	// if false, enemy hits
	public boolean enemyMisses(Enemies enemy, Player player) {
		
		
		return true;
	}
	
	//function that determines if the player's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public boolean playerCrit(Player player) {
		
		
		return false;
	}
	
	//function that determines if the enemy's hit was critical
	// if true, hit was critical
	// if false, hit was not critical
	public boolean enemyCrit(Enemies enemy) {
		
		
		return false;
	}
	
	//function that calculates player's attack damage
	public int playerDMG(Player player) {
		//checks if attack was a critical hit
		
		//calculates damage dealt
		int dmgDealt = player.bd + (player.STR * 1); 
		
		return dmgDealt;
	}
	
	//function that calculates enemy's attack damage
	public int enemyDMG(Enemies enemy) {
		//checks if attack was a critical hit
		
		//calculates damage dealt
		int dmgDealt = enemy.bd + (enemy.STR * 1);
		
		return dmgDealt;
	}
	
	//function that conducts operations for player attacking an enemy------------------
	public boolean attack(Player player, Enemies enemy) {
		
		//determines if attack hits or misses
		if (playerMisses(player, enemy)) {
			return false;
		}
		
		//determines attack damage
		int dmg = playerDMG(player);
		
		//subtracts damage from enemy hit points
		enemy.hp -= dmg;
		
		System.out.println(player.name + " deals " + dmg + " damage to " + enemy.name);
		
		return true;
	}
	
	//function that conducts operations for player fleeing combat
	public boolean flee(Player player) {
		playerTurn = false;
		enemyTurn = false;
		
		//TODO actually return player to Explore screen
		
		System.out.println(player.name + " flees!");
		
		return true;
	}
	
	//function that conducts operations for player using consumable--------------------------------------------
	public boolean useConsumable(Player player, Consumables consumable) {
		
		//determines healing
		int healing = consumable.healingpower;
		
		//adds healing to player hit points
		player.hp += healing;
		
		System.out.println(player.name + " uses " + consumable.name + " and heals " + healing + "hit points!");
		
		return true;
	}
	
	//function that conducts operations for enemy attacking the player-----------------
	public boolean attack(Enemies enemy, Player player) {
		
		//determines if attack hits or misses
		
		//determines damage
		int dmg = enemyDMG(enemy);
		
		//subtracts damage from player hit points
		player.hp -= dmg;
		
		System.out.println(enemy.name + " deals " + dmg + " damage to " + player.name);
		
		return true;
	}
	
}
