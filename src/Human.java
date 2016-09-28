import java.util.Scanner;

/**
 * Created by Greymoon on 9/28/2016.
 */
public class Human implements IPlayer {
    private static int playerCount = 0;
	private String name;
	private Game game;
	private IView view;
    private int id;

    public Human(IView view)
    {
        ++playerCount;
        this.view = view;
        view.displayMessage("Enter player " + playerCount + " name.");
        name = view.enterString();
        id = playerCount;
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
		view.displayState(currentState);

		view.displayMessage(name + ", what row would you like to choose: ");
		int rowIndex = view.chooseOption(game.FIRST_ROW, game.FINAL_ROW);

		int rowValue = currentState.getRow(rowIndex-1);

		view.displayMessage("How many do you want to take from row " + rowIndex + " ?");
		int subtractValue = view.chooseOption(1, rowValue);

		int newValue = rowValue - subtractValue;

		State newState = null;
		switch (rowIndex) {
		case 1:
			newState = new State(newValue, currentState.getRow(1), currentState.getRow(2));
			break;
		case 2:
			newState = new State(currentState.getRow(0), newValue, currentState.getRow(2));
			break;
		case 3:
			newState = new State(currentState.getRow(0), currentState.getRow(1), newValue);
			break;
		}

		game.setCurrentState(newState);

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
