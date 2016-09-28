
public class Engine {

	private static final String MAIN_MENU_OPTIONS =
			"Welcome to the game of nim.\n" +
			"Choose an option:\n" +
			"1.) Player vs Player\n" +
			"2.) Player vs Computer\n" +
			"3.) Computer vs Computer\n" +
			"0.) Exit";
	private static final int NUMBER_OF_MAIN_MENU_OPTIONS = 4;

	private Game game;
	private IView view;

	public Engine(IView view){
		this.view = view;
	}

	public void start() {
		menu();
	}
	private void menu() {
		boolean inMenu = true;
		while (inMenu)
		{
			view.displayMessage(MAIN_MENU_OPTIONS);
			int menuOption = view.chooseOption(0, NUMBER_OF_MAIN_MENU_OPTIONS);
			switch (menuOption)
			{
			case 0:
				inMenu = false;
				break;
			case 1:
				run(new Game(new Human(view), new Human(view)));
				break;
			case 2:
				run(new Game(new Human(view), new Computer(view)));
				break;
			case 3:
				run(new Game(new Computer(view), new Computer(view)));
				break;
			}
		}
		view.displayMessage("Thanks for playing.");
	}
	public void run(Game game){
		this.game = game;
		gameLoop();
	}
	
	public void gameLoop(){
		for(boolean gameOver = false; !gameOver; gameOver = game.checkGameOver()) {
			game.update();
		}
	}
	
}
