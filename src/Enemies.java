
public class Enemies extends Player implements GameElement {
	
	boolean isDefeated;
	
	//black constructor for subclasses
	public Enemies() {
		
	}

	//null constructor for nullEnemy if needed
	public Enemies(int x, int y) {
		
	}
	
	public static Enemies makeNullEnemy(int x, int y) {
		Enemies nullEnemy = new Enemies(x, y);
		
		return nullEnemy;
	}

	@Override
	public void write(String filename) {
		// TODO Auto-generated method stub
		
	}

	//makes a specific enemy based on String argument
	public static Enemies makeCertainEnemy(String areaAreaEnemy, int areaPosX, int areaPosY) {
		System.out.println("makeCertainEnemy was passed " + areaAreaEnemy);
		
		String enemyName = areaAreaEnemy;
		
		Enemies madeEnemy = null;
		
		if (enemyName == "Beetle") {
			madeEnemy = Beetle.makeBeetle(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Boar") {
			madeEnemy = Boar.makeBoar(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Canid") {
			madeEnemy = Canid.makeCanid(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Cappa") {
			madeEnemy = Cappa.makeCappa(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Emu") {
			madeEnemy = Emu.makeEmu(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Kera") {
			madeEnemy = Kera.makeKera(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Khan") {
			madeEnemy = Khan.makeKhan(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Klaus") {
			madeEnemy = Klaus.makeKlause(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Leo") {
			madeEnemy = Leo.makeLeo(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Neko") {
			madeEnemy = Neko.makeNeko(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Snake") {
			madeEnemy = Snake.makeSnake(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Tortooga") {
			madeEnemy = Tortooga.makeTortooga(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Ursa") {
			madeEnemy = Ursa.makeUrsa(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else if (enemyName == "Wolf") {
			madeEnemy = Wolf.makeWolf(areaPosX, areaPosY);
			
			System.out.println("Enemy " + madeEnemy.name + " made.");
			
			return madeEnemy;
		}
		
		else {
			System.out.println("No enemy made.");
			
			return madeEnemy;
		}
	}

}