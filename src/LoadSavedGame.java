import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadSavedGame {

	//function that will load the player's save file according to their username
	@SuppressWarnings("unused")
	public static void loadSave(String username) {
		BufferedReader bufferedReader;
		
		String line;
		
		//Opens UserPass.txt----------------------------------------------------------------
		try {
			bufferedReader = new BufferedReader(new FileReader("src/" + username + ".txt"));
			
			//TODO! LOTS TODO!
			//
			while((line = bufferedReader.readLine()) != null) {
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
