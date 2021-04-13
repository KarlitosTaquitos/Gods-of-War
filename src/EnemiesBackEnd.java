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
	
}
