/**
 * Created by Greymoon on 10/6/2016.
 */
public class Program {
    private static final String MAIN_MENU_OPTIONS =
            "Welcome to the game of nim.\n" +
                    "Choose an option:\n" +
                    "1.) Player vs Player\n" +
                    "2.) Player vs Computer\n" +
                    "3.) Computer vs Computer\n" +
                    "0.) Exit";
    private static final int NUMBER_OF_MAIN_MENU_OPTIONS = 4;
    private static final int MAX_NUMBER_OF_GAMES = 1000;

    private IView view;
    private Engine engine;

    public void run(){
        view = new Console();
        engine = new Engine();
        menu();
    }
    public void menu() {
        for (boolean inMenu = true; inMenu;)
        {
            view.displayMessage(MAIN_MENU_OPTIONS);
            int userChoice = view.chooseOption(0, NUMBER_OF_MAIN_MENU_OPTIONS);
            MenuOptionEnum programAction = MenuOptionEnum.values()[userChoice];
            if(programAction == MenuOptionEnum.EXIT) inMenu = false;
            else
            {
                IPlayer playerOne = (programAction == MenuOptionEnum.COMPUTER_VS_COMPUTER)
                        ? new Computer(view) : new Human(view);
                IPlayer playerTwo = (programAction == MenuOptionEnum.PLAYER_VS_PLAYER)
                        ? new Human(view) : new Computer(view);

                if (programAction == MenuOptionEnum.COMPUTER_VS_COMPUTER)
                {
                    view.displayMessage("How many games would you like to run?");
                    for (int i = view.chooseOption(0, MAX_NUMBER_OF_GAMES); i > 0; --i)
                        engine.run(new Game(new Computer(view), new Computer(view)));
                }
                else engine.run(new Game(playerOne, playerTwo));
            }
        }
        view.displayMessage("Thanks for playing.");
    }
}
