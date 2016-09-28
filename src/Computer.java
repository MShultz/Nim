/**
 * Created by Greymoon on 9/28/2016.
 */
public class Computer implements IPlayer {
    private static int computerCount = 0;
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
        State[] possibleStates = new State[0];
        for (State state : possibleStates) {
            if (newState == null) {
                newState = state;
            }
            else if (state.getAverage() > newState.getAverage()){
                newState = state;
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
