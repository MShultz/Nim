public class Engine {

	private Game game;

	public void run(Game game){
		this.game = game;
		gameLoop();
	}
	
	private void gameLoop(){
		for(boolean gameOver = false; !gameOver; gameOver = game.checkGameOver()) {
			game.update();
		}
	}
	
}
