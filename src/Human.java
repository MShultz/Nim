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
		int rowIndex = getRow();
		int rowValue = currentState.getRow(rowIndex-1);
		int subtractValue = getAmountFromRow(rowIndex, rowValue);
		int newRowValue = rowValue - subtractValue;
		State newState = generateNextState(currentState, rowIndex, newRowValue);

		game.setCurrentState(newState);
	}

	private int getRow() {
		view.displayMessage(name + ", what row would you like to choose: ");
		return view.chooseOption(Game.FIRST_ROW, Game.FINAL_ROW);
	}

	private int getAmountFromRow(int rowIndex, int rowValue){
		view.displayMessage("How many do you want to take from row " + rowIndex + " ?");
		return view.chooseOption(1, rowValue);
	}
	private State generateNextState(State currentState, int rowIndex, int newRowValue) {
		State newState = null;
		switch (rowIndex) {
			case 1:
				newState = new State(newRowValue, currentState.getRow(1), currentState.getRow(2));
				break;
			case 2:
				newState = new State(currentState.getRow(0), newRowValue, currentState.getRow(2));
				break;
			case 3:
				newState = new State(currentState.getRow(0), currentState.getRow(1), newRowValue);
				break;
		}
		return newState;
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
