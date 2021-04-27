import java.io.*;
import java.util.Vector;

public class HighScoreBackEnd {

    //class used for sorting and writing
    private static class Entry {
        String user;
        int score;

        Entry(String x, int s) {
            user = x;
            score = s;
        }
    };
    
    public static String getScores() throws IOException{
        String finalString = "<html>";

        BufferedReader highScores = new BufferedReader(new FileReader("src/highscores.txt"));
        String line;

        while ((line = highScores.readLine()) != null) {
            String[] tokens = line.split(" ");
            finalString += tokens[0] + ": " + tokens[1] + "<br/>";
        }

        highScores.close();

        finalString += "</html>";
        return finalString;
    }

    public static void addScore(Player player, int score) {
        
        try {            
    
            BufferedReader highScores = new BufferedReader(new FileReader("src/highscores.txt"));
            Vector<Entry> arr = readIntoVector(highScores, player, score);

            highScores.close();

            BufferedWriter outputScores = new BufferedWriter(new FileWriter("src/highscores.txt", false));
            writeScores(outputScores, arr);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Vector<Entry> readIntoVector(BufferedReader highscores, Player player, int score) throws IOException {
        Vector<Entry> arr = new Vector<Entry>();

        String line;

        //create array of all the high scores we have
        while ((line = highscores.readLine()) != null) {
            String[] tokens = line.split(" ");

            Entry newEntry = new Entry(tokens[0], Integer.parseInt(tokens[1]));

            arr.add(newEntry);
        }

        //add new one into array
        Entry playerEntry = new Entry(player.name, score);
        arr.add(playerEntry);

        //bubbling
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.elementAt(i).score > arr.elementAt(i - 1).score) {
                arr.insertElementAt(arr.get(i), i - 1);
                arr.remove(arr.lastElement());
            }
        }

        //limit the size
        while (arr.size() > 5)
            arr.remove(arr.lastElement());

        return arr;
    }

    private static void writeScores(BufferedWriter output, Vector<Entry> scores) throws IOException {
        for (Entry score : scores) {
            output.write(score.user + " " + score.score + "\n");
        }
    }
}
