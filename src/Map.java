
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
	Area[][] map;
	
	//constructor for map, setting the map's size to the given size
	// and constructing the size x size grid
	//sets player to the start of map (map[0][0], but position[1][1])
	Map(int size) {
		//sets map's size
		this.size = size;
		
		//for loops that create the size x size grid
		// minus 1 because arrays start at 0,
		// which would create maps of undesired size
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				
				//constructs Area for each sector of the size x size grid
				// i and j are plus'd 1 because arrays start at 0 (i.e [0][0]),
				// but position starts at 1 (i.e [1][1])
				map[i][j] = new Area(i + 1, j + 1);
				
			}
			
		}
		
		//sets boolean of starting area for player being there to true
		map[0][0].playerInArea = true;
	}
	
	@SuppressWarnings("unused")
	//function that constructs a map from given size
	void makeMap(int size) {
	//	map = new Area[size][size];
		
		Map gameMap = new Map(size);
	}

	//function that populates map with enemies, consumables, and rest areas,
	// given the size of the map
	void fillMap(Map map)
	{
		ExploreMapBackEnd.fillMapEnemies(map);
		
		ExploreMapBackEnd.fillMapConsumables(map);
		
		//TODO function below requires RestArea class to work
		//ExploreMapBackEnd.fillMapRestAreas(map);
	}
	
}
