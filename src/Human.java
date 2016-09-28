import java.util.Scanner;

/**
 * Created by Greymoon on 9/28/2016.
 */
public class Human implements IPlayer {
	private static final int FIRST_ROW = 1;
	private static final int FINAL_ROW = 3;
	private String name;
	private Game game;
	private IView view;

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

		view.displayMessage("What row would you like to choose: ");
		int rowIndex = view.chooseOption(FIRST_ROW, FINAL_ROW);

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
}
