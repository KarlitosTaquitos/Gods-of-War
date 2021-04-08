
public class BattleBackEnd {

	//booleans that dictate which turn it is
	boolean playerTurn;
	boolean enemyTurn;
	
	//function that calculates player's damage------
	public int playerDMG(Player player) {
		int dmgDealt = player.bd + (player.STR * 1); 
		
		return dmgDealt;
	}
	
	//function that calculates enemy's damage-----
	public int enemyDMG(Enemies enemy) {
		int dmgDealt = enemy.bd + (enemy.STR * 1);
		
		return dmgDealt;
	}
	
	//function that conducts operations for player attacking an enemy------------------
	public boolean attack(Player player, Enemies enemy) {
		int dmg = playerDMG(player);
		
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
		int healing = consumable.healingpower;
		
		player.hp += healing;
		
		System.out.println(player.name + " uses " + consumable.name + " and heals " + healing + "hit points!");
		
		return true;
	}
	
	//function that conducts operations for enemy attacking the player-----------------
	public boolean attack(Enemies enemy, Player player) {
		int dmg = enemyDMG(enemy);
		
		player.hp -= dmg;
		
		System.out.println(enemy.name + " deals " + dmg + " damage to " + player.name);
		
		return true;
	}
	
}
