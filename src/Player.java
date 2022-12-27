import java.util.Random;

public class Player {

	int score = 0; 
	Game game;
	Random random = new Random();
	
	
	public Player(Game game) {		
		this.game = game;		
	}
	
	public void collectEgg() {		
		if(game.egg.collect) {
			score ++;
			game.egg.randomY[game.egg.index] = 10;
			game.egg.randomX[game.egg.index] = random.nextInt(400)+20;
		}
		
	}

}
