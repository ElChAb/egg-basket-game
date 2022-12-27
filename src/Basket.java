import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Basket implements KeyListener{
		
	BufferedImage basketImg;
	private int x = 200, y = 350 ;
	Game game;	
	boolean bl = false;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paint(Graphics g) {		
		g.drawImage(basketImg, x, y, 100, 100, null);

	}
	

	public Basket(Game game) {
		
		this.game = game;
		
		try {
			
			basketImg = ImageIO.read(new File("basket.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	public Rectangle getBounds() {		
		return new Rectangle(x, y, basketImg.getWidth(), basketImg.getHeight());		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(x > 20) {
				x -= 20;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(x < 350) {
				x += 20;
			}
					
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
