import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

public class Game extends JPanel implements Runnable, KeyListener {

	BufferedImage board, gameOver ;
	Thread runGame;	
	Egg egg =  new Egg(this);
	Basket basket = new Basket(this);
	Player player = new Player(this);
	
	
	@Override
	public void addNotify() {
		super.addNotify();
		runGame = new Thread(this);
		runGame.start();	
	}
	
	
	@Override
	public void paint(Graphics g2) {
		
		super.paint(g2);	
		g2.drawImage(board, 0, 0, 500, 500, null);
		
		egg.paint(g2);
		basket.paint(g2);
		player.collectEgg();
		
		Font font = new Font("arial", Font.BOLD, 20);
		g2.setFont(font);
		g2.setColor(Color.black);
		g2.drawString("Score: "+ player.score, 380, 20);
	}
	
	
	public Game() {
			
		try {
			
			board = ImageIO.read(new File("farm3.jpg"));
			gameOver = ImageIO.read(new File("game-over.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void move() {
		egg.moveEgg();
	}


	@Override
	public void run() {	
		while(true) {
			
			repaint();
			move();
			
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		basket.keyPressed(e);		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
