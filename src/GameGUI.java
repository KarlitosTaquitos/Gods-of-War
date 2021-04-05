import javax.swing.*;

public class GameGUI {
	private static int state = 0;
	private static JFrame frame;
	
	
	public static void main(String[] args) {
		frame = new JFrame();
		mainScreen();
	}
	
	public static void mainScreen() {
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
