import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;

public class Egg {

	private BufferedImage eggImg, friedImg;
	int eggNumber = 4;
	private int x , y;
	Random random = new Random();	
	int randomX[] = new int[eggNumber];
	int randomY[] = new int[eggNumber];	
	Game game;
	Rectangle rectangle = new Rectangle();
	boolean collect = true, loose = false;
	int r = 0;
	int index = 0;
	
	
	
	public void paint(Graphics g) {		
		
		getBounds();
		
		if(loose) {
			g.drawImage(friedImg, randomX[index], randomY[index], 50, 50, null);
			g.drawImage(game.gameOver, 80, 50, 300, 300, null);
			game.runGame.stop();
		}
		
		else {
			for(int i=0 ; i < eggNumber; i++) {	
				
				x = randomX[i];
				y = randomY[i];
				
				g.drawImage(eggImg, x, y, 50, 50, null);
			}
		}
		

	}
	
	
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

	public void randomX() {
		
		for(int i = 0 ; i < eggNumber ; i++) {			
			randomX[i] = random.nextInt(400)+10;
		}
		
//**********  generate diffrent x
		for(int i = 0 ; i < eggNumber ; i++) {
			for(int j = i+1 ; j < eggNumber ; j++) {
				if(randomX[i] == randomX[j]) {
					if(randomX[i] < 400 ) {
						randomX[i] += 50;
					}
					else if( randomX[i] > 70) {
						randomX[i] -= 50;
					}
					
				}

			}

		}
		
	}
	
	int startP = -300;
	
	public void randY() {
		
	}
	
	public void randomY() {	
		
		randomY[0] = random.nextInt(10)+startP;
		
		for(int i=1; i < randomY.length ; i++) {
			randomY[i] = randomY[i-1] + 50;
		}
		
	}
	
	public Egg(Game game) {
		
		this.game = game;
		
		randomX();
		randomY();

		try {
			
			eggImg = ImageIO.read(new File("egg.png"));
			friedImg = ImageIO.read(new File("fried-egg.png"));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveEgg() {	
		for(int i = 0; i < randomY.length ; i++) {
			randomY[i]  += 10;
			y = randomY[i];
		}
		
	}

//******** return all egg bounds	
	public Rectangle getBounds() {		
		for( r = 0; r < eggNumber; r++) {
			rectangle = new Rectangle(randomX[r], randomY[r], eggImg.getWidth(), eggImg.getHeight());
			collision();
		}
			
		return rectangle;
	}

//********** check collision for each egg	
	 public void collision() {	
		 	collect = false;
			if(game.basket.getBounds().intersects(rectangle)) {
				index = r;
				collect = true;
				game.player.collectEgg();
			}		
			else if(!collect && randomY[r] > 400) {
				index = r;
				loose = true;
			}
			
		}
	

}
