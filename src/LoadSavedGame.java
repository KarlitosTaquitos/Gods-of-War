import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadSavedGame {

	static String[] words;

	//variables that hold player information----------------------------
	static String playerName;
	static int playerPosX, playerPosY, playerAPpool, playerHP, playerBD;
	static int playerEnemiesDefeated, playerPlayerDefeat;
	static int playerSTR, playerINT, playerCON, playerSPD;
	static int playerFood, playerSMPot, playerLGPot;
	static int playerLastRestAreaX, playerLastRestAreaY;
	
	//variables that hold map information
	static int mapSize;
	
	//variables that hold area information-------------------------------------------------
	static int areaPosX, areaPosY;
	static boolean areaPlayerInArea, areaEnemyInArea, areaConsumableInArea, areaIsRestArea;
	static String areaAreaEnemy, areaAreaConsumable;
	
	static BufferedReader bufferedReader;
	
	static String line;
	
	//function that will load the player's save file according to their username------------------------
	public static boolean loadSave() {
		//System.out.println("Loading Player...");
		try {
		
			loadPlayer();
			
			//System.out.println("Player Loaded.");
			//System.out.println("Creating Player...");
			
			GamePlay.player = Player.makePlayer(playerName, playerPosX, playerPosY,
					playerAPpool, playerHP, playerBD, playerEnemiesDefeated, playerPlayerDefeat,
					playerSTR, playerINT, playerCON, playerSPD,
					playerFood, playerSMPot, playerLGPot,
					playerLastRestAreaX, playerLastRestAreaY);
			
			//System.out.println("Player created.");
			//System.out.println("Loading map.");
			
			loadMap();

			//System.out.println("Map Loaded.");
			//System.out.println("Creating Map...");
			
			GamePlay.map = Map.makeMap(mapSize + 1);

			//System.out.println("Map Created.");
			//System.out.println("Loading Areas...");
			
			loadAreas();

			//System.out.println("Areas Loaded.");
			return true;
		}
		catch (Exception e)
		{ return false; }
		
	}
	
	//helper function that loads player information
	public static void loadPlayer() {
		try {
			bufferedReader = new BufferedReader(new FileReader("src/" + GamePlay.player.name + ".txt"));

			//if opened, reads through save file for information
			while ((line = bufferedReader.readLine()) != null) {
				words = line.split(" ");
				
				if (words[0].equals("playerName")) {
					playerName = words[1];
					
					//System.out.println("player name: " + playerName);
				}
				
				else if (words[0].equals("playerPositionX")) {
						playerPosX = Integer.parseInt(words[1]);
					
					//System.out.println("player position x: " + playerPosX);
				}
				
				else if (words[0].equals("playerPositionY")) {
					playerPosY = Integer.parseInt(words[1]);
					
					//System.out.println("player position y: " + playerPosY);
				}
				
				else if (words[0].equals("playerAPpool")) {
					playerAPpool = Integer.parseInt(words[1]);
					
					//System.out.println("player APpool: " + playerAPpool);
				}
				
				else if (words[0].equals("playerHP")) {
					playerHP = Integer.parseInt(words[1]);
					
					//System.out.println("player hp: " + playerHP);
				}
				
				else if (words[0].equals("playerBD")) {
					playerBD = Integer.parseInt(words[1]);
					
					//System.out.println("player bd: " + playerBD);
				}
				
				else if (words[0].equals("playerEnemiesDefeated")) {
					playerEnemiesDefeated = Integer.parseInt(words[1]);
					
					//System.out.println("player enemiesDefeated: " + playerEnemiesDefeated);
				}
				
				else if (words[0].equals("playerPlayerDefeat")) {
					playerPlayerDefeat = Integer.parseInt(words[1]);
					
					//System.out.println("player playerDefeat: " + playerPlayerDefeat);
				}
				
				else if (words[0].equals("playerSTR")) {
					playerSTR = Integer.parseInt(words[1]);
					
					//System.out.println("player STR: " + playerSTR);
				}
				
				else if (words[0].equals("playerINT")) {
					playerINT = Integer.parseInt(words[1]);
					
					//System.out.println("player INT: " + playerINT);
				}
				
				else if (words[0].equals("playerCON")) {
					playerCON = Integer.parseInt(words[1]);
					
					//System.out.println("player CON: " + playerCON);
				}
				
				else if (words[0].equals("playerSPD")) {
					playerSPD = Integer.parseInt(words[1]);
					
					//System.out.println("player SPD: " + playerSPD);
				}
				
				else if (words[0].equals("playerFood")) {
					playerFood = Integer.parseInt(words[1]);
					
					//System.out.println("player food: " + playerFood);
				}
				
				else if (words[0].equals("playerSMPot")) {
					playerSMPot = Integer.parseInt(words[1]);
					
					//System.out.println("player smPot: " + playerSMPot);
				}
				
				else if (words[0].equals("playerLGPot")) {
					playerLGPot = Integer.parseInt(words[1]);
					
					//System.out.println("player lgPot: " + playerLGPot);
				}
				
				else if (words[0].equals("playerLastRestAreaX")) {
					playerLastRestAreaX = Integer.parseInt(words[1]);
					
					//System.out.println("player lastRestArea x: " + playerLastRestAreaX);
				}
				
				else if (words[0].equals("playerLastRestAreaY")) {
					playerLastRestAreaY = Integer.parseInt(words[1]);
					
					//System.out.println("player lastRestArea y: " + playerLastRestAreaX);
				}
				
				else {
					
				}
				
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//helper function that loads map information
	public static void loadMap() {
		try {
			bufferedReader = new BufferedReader(new FileReader("src/" + GamePlay.player.name + ".txt"));

			//if opened, reads through save file for information
			while ((line = bufferedReader.readLine()) != null) {
				words = line.split(" ");
				
				if (words[0].equals("mapSize")) {
					mapSize = Integer.parseInt(words[1]);
					
					//System.out.println("map size: " + mapSize);
				}
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//helper function that loads area information
	public static void loadAreas() {
		try {
			bufferedReader = new BufferedReader(new FileReader("src/" + GamePlay.player.name + ".txt"));

			//if opened, reads through save file for information
			while ((line = bufferedReader.readLine()) != null) {
				words = line.split(" ");
				
				for (int i = 1; i <= mapSize * mapSize; i++) {
					if (words[0].equals(String.valueOf(i))) {
						if (words[1].equals("areaPositionX")) {
							areaPosX = Integer.parseInt(words[2]);
							
							//System.out.println("Area " + i + " position x " + areaPosX);
						}
						
						if (words[1].equals("areaPositionY")) {
							areaPosY = Integer.parseInt(words[2]);
							
							//System.out.println("Area " + i + " position y " + areaPosY);
						}
						
						if (words[1].equals("areaPlayerInArea")) {
							areaPlayerInArea = Boolean.parseBoolean(words[2]);
							
							Map.map[areaPosX][areaPosY].playerInArea = true;
							
							//System.out.println("Area " + i + " playerInArea " + areaPlayerInArea);
						}
						
						if (words[1].equals("areaEnemyInArea")) {
							areaEnemyInArea = Boolean.parseBoolean(words[2]);
							
							if (areaEnemyInArea == true) {
							
								//System.out.println("Area " + i + " enemyInArea " + areaEnemyInArea);
								
							}
							
						}
						
						if (areaEnemyInArea == true) {
							if (words[1].equals("areaAreaEnemy")) {
								if (words[2].equals("God's")) {
									areaAreaEnemy = words[2] + " " + words[3];
									
									Map.map[areaPosX][areaPosY].areaEnemy = GodsChosen.makeGodsChosen(areaPosX, areaPosY);
								}
								
								else if (words[2].equals("Beetle")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Beetle.makeBeetle(areaPosX, areaPosY);
								}
							
								else if (words[2].equals("Boar")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Boar.makeBoar(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Canid")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Canid.makeCanid(areaPosX, areaPosY);
								
								}
								
								else if (words[2].equals("Cappa")) {

									areaAreaEnemy = words[2];
									Map.map[areaPosX][areaPosY].areaEnemy = Cappa.makeCappa(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Emu")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Emu.makeEmu(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Kera")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Kera.makeKera(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Khan")) {

									areaAreaEnemy = words[2];
									Map.map[areaPosX][areaPosY].areaEnemy = Khan.makeKhan(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Klaus")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Klaus.makeKlause(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Leo")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Leo.makeLeo(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Neko")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Neko.makeNeko(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Snake")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Snake.makeSnake(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Tortooga")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Tortooga.makeTortooga(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Ursa")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Ursa.makeUrsa(areaPosX, areaPosY);
								
								}
							
								else if (words[2].equals("Wolf")) {
									areaAreaEnemy = words[2];
									
									Map.map[areaPosX][areaPosY].areaEnemy = Wolf.makeWolf(areaPosX, areaPosY);
								
								}
							
								//System.out.println("Area " + i + " enemy " + areaAreaEnemy);
							}
						}
						
						if (words[1].equals("areaConsumableInArea")) {
							areaConsumableInArea = Boolean.parseBoolean(words[2]);
							
							//System.out.println("Area " + i + " consumableInArea " + areaConsumableInArea);
						}
						
						if (areaConsumableInArea == true) {
							if (words[1].equals("areaAreaConsumable")) {
								
								if (words[2].equals("Food")) {
									areaAreaConsumable = words[2];
									
									Map.map[areaPosX][areaPosY].areaConsumbale = Food.makeFood(areaPosY, areaPosY);
								}
								
								else if (words[2].equals("Small")) {
									areaAreaConsumable = words[2] + " " + words[3];
									
									Map.map[areaPosX][areaPosY].areaConsumbale = smPot.makeSMPot(areaPosX, areaPosY);
								}
								
								else if (words[2].equals("Large")) {
									areaAreaConsumable = words[2] + " " + words[3];
									
									Map.map[areaPosX][areaPosY].areaConsumbale = lgPot.makeLGPot(areaPosX, areaPosY);
								}
								
							//	System.out.println("Area " + i + " consumable " + areaAreaConsumable);
							}
						}
						
						if (words[1].equals("areaIsRestArea")) {
							areaIsRestArea = Boolean.parseBoolean(words[2]);
							
							Map.map[areaPosX][areaPosY].isRestArea = true;
							
							//System.out.println("Area " + i + " isRestArea " + areaIsRestArea);
							System.out.println("");
						}
						
						Map.map[areaPosX][areaPosY].playerInArea = areaPlayerInArea;
						Map.map[areaPosX][areaPosY].enemyInArea = areaEnemyInArea;
						Map.map[areaPosX][areaPosY].consumableInArea = areaConsumableInArea;
						Map.map[areaPosX][areaPosY].isRestArea = areaIsRestArea;
					}
				}
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
