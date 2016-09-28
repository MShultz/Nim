/**
 * Created by Greymoon on 9/28/2016.
 */
public class Computer implements IPlayer {
    private static int computerCount = 100;
    private String name;
    private Game game;
    private IView view;
    private int id;

    public Computer(IView view)
    {
        ++computerCount;
        this.view = view;
        name = "Computer" + computerCount;
        id = computerCount;
    }
    @Override
    public void setPlayerName(String name) {
        this.name = name;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void takeTurn() {
        State currentState = game.getCurrentState();

        State newState = null;
        String[] possibleStates = Brain.getPossibleStates(currentState);
        for (String stateKey : possibleStates) {
            State possibleState = Brain.getState(stateKey);
            if (newState == null || possibleState.getAverage() > newState.getAverage()){
                newState = possibleState;
            }
        }
        game.setCurrentState(newState);
        view.displayMessage(name + " has set the game state to " + newState.getKey());
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public int getId() {
        return id;
    }
}
