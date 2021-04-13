import java.util.Random;

public class EnemiesBackEnd {
	
	//generates a random Enemy with given position x, y
	static Enemies makeRandWeakEnemy(int x, int y) {
		
		Random rand = new Random();
		
		int randE = rand.nextInt(5);
		
		Enemies randEnemy = Enemies.makeNullEnemy(x, y);
		
		if (randE == 0) {
			randEnemy = Beetle.makeBeetle(x, y);
		}
		
		else if (randE == 1) {
			randEnemy = Boar.makeBoar(x, y);
		}
		
		else if (randE == 2) {
			randEnemy = Emu.makeEmu(x, y);
		}
		
		else if (randE == 3) {
			randEnemy = Snake.makeSnake(x, y);
		}
		
		else if (randE == 4) {
			randEnemy = Wolf.makeWolf(x, y);
		}
		
		return randEnemy;
		
	}
	
	static Enemies makeRandStrongEnemy(int x, int y) {

		Random rand = new Random();
		
		int randE = rand.nextInt(5);
		
		Enemies randEnemy = Enemies.makeNullEnemy(x, y);
	
		if (randE == 0) {
			randEnemy = Canid.makeCanid(x, y);
		}
	
		else if (randE == 1) {
			randEnemy = Cappa.makeCappa(x, y);
		}
	
		else if (randE == 2) {
			randEnemy = Kera.makeKera(x, y);
		}
	
		else if (randE == 3) {
			randEnemy = Neko.makeNeko(x, y);
		}
		
		else if (randE == 4) {
			randEnemy = Tortooga.makeTortooga(x, y);
		}
		
		return randEnemy;
		
	}
	
	//generates a boss at the end of the map
	static Enemies makeBaseBoss(Map map) {
		
		Enemies baseBoss = Ursa.makeUrsa(map.size - 1, map.size - 1);
		
		Map.map[map.size - 1][map.size - 1].areaEnemy = baseBoss;
		
		Map.map[map.size - 1][map.size - 1].enemyInArea = true;
		
		return baseBoss;
	}
	
	//updates boss according to player's attributes
	static Enemies updateBoss(Player player, Map map) {
		
		int mapEnd = map.size - 1;
		
		Enemies newBoss;
		
		if (player.STR > player.CON && player.STR > player.SPD)
		{
			newBoss = Klaus.makeKlause(mapEnd, mapEnd);
		}
		
		else if (player.CON > player.STR && player.CON > player.SPD)
		{
			newBoss = Khan.makeKhan(mapEnd, mapEnd);
		}
		
		else if (player.SPD > player.STR && player.SPD > player.CON)
		{
			newBoss = Leo.makeLeo(mapEnd, mapEnd);
		}
		
		else
			newBoss = Ursa.makeUrsa(map.size - 1, map.size -1);
		
		Map.map[mapEnd][mapEnd].areaEnemy = newBoss;
		
		return newBoss;
	}
	
}
