import java.io.*;

public class Map {
	
	//variable holding map's size
	//6 for small
	//8 for medium
	//10 for large
	int size;
	
	//array of Areas that represents the map (a size x size grid)
	//6 x 6 for small
	//8 x 8 for medium
	//10 x 10 for large
	static Area[][] map;
	
	//constructor for map, setting the map's size to the given size
	// and constructing the size x size grid
	//sets player to the start of map (map[0][0], but position[1][1])
	Map(int size) {
		//sets map's size
		this.size = size;
		
		//for loops that create the size x size grid
		// which would create maps of undesired size
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				
				//constructs Area for each sector of the size x size grid
				// i and j are plus'd 1 because arrays start at 0 (i.e [0][0]),
				// but position starts at 1 (i.e [1][1])
				map[i][j] = new Area(i + 1, j + 1);
				
			}
			
		}
		
		//sets boolean of starting area for player being there to true
		Map.map[1][1].playerInArea = true;
	}
	
	//function that constructs a map from given size
	static Map makeMap(int size) {
		
		map = new Area[size][size];
		
		Map gameMap = new Map(size);
		
		fillMap(gameMap);
		
		return gameMap;
	}

	//function that populates map with enemies, consumables, and rest areas,
	// given the size of the map
	static void fillMap(Map map){

		ExploreMapBackEnd.fillMapRestAreas(map);
		
		EnemiesBackEnd.makeBaseBoss(map);
		
		ExploreMapBackEnd.fillMapEnemies(map);
		
		ExploreMapBackEnd.fillMapConsumables(map);
	}
	
	public void write(String filename) throws IOException {
		BufferedWriter saver = new BufferedWriter(new FileWriter(filename, true));
		
		saver.write("\n" + "Map information");
		saver.write("\n" + "map size " + (GamePlay.map.size - 1));
		saver.write("\n");
		
		int areaCount = 0;
		
		for (int x = 1; x <= GamePlay.map.size - 1; x++) {
			for (int y = 1; y <= GamePlay.map.size - 1; y++) {
				areaCount++;
				saver.write("\n" + "Area " + areaCount + " Information");
				saver.write("\n"+ "area position x " + x);
				saver.write("\n" + "area position y " + y);
				saver.write("\n" + "area playerInArea " + Map.map[x][y].playerInArea);
				saver.write("\n" + "area enemyInArea " + Map.map[x][y].enemyInArea);
				
				if (Map.map[x][y].enemyInArea == true) {
					saver.write("\n" + "area areaEnemy " + Map.map[x][y].areaEnemy.name);
				}
				
				saver.write("\n" + "area areaConsumable " + Map.map[x][y].consumableInArea);
				
				if (Map.map[x][y].consumableInArea == true) {
					saver.write("\n" + "area areaConsumable " + Map.map[x][y].areaConsumbale.name);
				}
				
				saver.write("\n" + "area isRestArea " + Map.map[x][y].isRestArea);
				
				saver.write("\n");
			}
		}
		
		saver.write("\n" + "End of Map information.");
		
		saver.close();
	}
	
}
