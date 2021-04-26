import java.io.*;

public class SaveGame {

	public static void saveGameFile(Player player, Map map) {
		
		//checks if file unique to username exists---------------
		// if it does, deletes the old file first,
		// in any case, creates a new save file
		String filename = "src/" + player.name + ".txt";
		
		File doomedFile = new File(filename);
		
		if (doomedFile.exists()) {
			if(doomedFile.delete()) {
				System.out.println("File deleted successfully.");
			}
			
			else {
				System.out.println("Failed to delete the file.");
			}
				
		}
		
		//creates file unique to username-----------------------	
		try {
			File newFile = new File(filename);
			
			if (newFile.createNewFile()) {
				System.out.println("File created: " + newFile.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//saves player------------------------
		try {
			player.write(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//saves map
		try {
			map.write(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
