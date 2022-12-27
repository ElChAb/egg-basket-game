import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{

	JButton button;
	
	public Main() {
		
		setSize(500,500);
		setTitle("Egg Basket");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		Game game = new Game(); 		
		add(game);	
		addKeyListener(game);
		
		setVisible(true);

		
	}

	public static void main(String[] args) {

		new Main();

	}


}
