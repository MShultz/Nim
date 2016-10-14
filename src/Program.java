/**
 * Created by Greymoon on 10/6/2016.
 */
public class Program {
	private static final String MAIN_MENU_OPTIONS = "Welcome to the game of nim.\n" + "Choose an option:\n"
			+ "1.) Player vs Player\n" + "2.) Player vs Computer\n" + "3.) Computer vs Computer\n" + "0.) Exit";
	private static final int NUMBER_OF_MAIN_MENU_OPTIONS = 4;
	private static final int MAX_NUMBER_OF_GAMES = 1000;

	private IView view;
	private Engine engine;

	public void run() {
		view = new Console();
		engine = new Engine();
		menu();
	}

	public void menu() {
		for (boolean inMenu = true; inMenu;) {
			view.displayMessage(MAIN_MENU_OPTIONS);
			int userChoice = view.chooseOption(0, NUMBER_OF_MAIN_MENU_OPTIONS);
			MenuOptionEnum programAction = MenuOptionEnum.values()[userChoice];
			if (programAction == MenuOptionEnum.EXIT) inMenu = false;
			else {
				int totalGames = 1;
				if (programAction == MenuOptionEnum.COMPUTER_VS_COMPUTER) {
					view.displayMessage("How many games would you like to run?");
					totalGames = view.chooseOption(0, MAX_NUMBER_OF_GAMES);
				}
				for (int gameIteration = 0; gameIteration < totalGames; ++gameIteration) {
					engine.run(programAction.makeGameWithView(view));
				}
			}
		}
		view.displayMessage("Thanks for playing.");
	}
}
