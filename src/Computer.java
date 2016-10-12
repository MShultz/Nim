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
        State newState = new State();
        String[] allPossibleStates = Brain.getPossibleStates(currentState.getRows());
        for (String stateKey : allPossibleStates) {
            State currentPossibleState = Brain.getState(stateKey);
            if (currentPossibleState.getAverage() >= newState.getAverage()){
                newState = currentPossibleState;
            }
        }
        if (!newState.equals(new State()))
        {
            game.setCurrentState(newState);
            view.displayMessage(name + " has set the game state to " + newState.getKey());
        }
    }

    @Override
    public void lose() {
        view.displayMessage(name + " has lost the game.");
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
