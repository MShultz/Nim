import java.util.ArrayList;

public class Game {

	private static final State GAME_START_STATE = new State(3, 5, 7);
	private static final State GAME_OVER_STATE = new State(0, 0, 0);
	public static final int FIRST_ROW = 1;
	public static final int FINAL_ROW = 3;

	private ArrayList<State> previousStates = new ArrayList<State>();
	private IPlayer[] players = new IPlayer[2];
	private IPlayer currentPlayer;
	private State currentState;
	private int turnCount = 0;

	public Game(IPlayer player1, IPlayer player2) {
		players[0] = player1;
		players[1] = player2;
		for (IPlayer player : players) {
			player.setGame(this);
		}
		currentState = GAME_START_STATE;
		currentPlayer = players[RandomSingleton.RandomIntInRange(0,1)];
	}

	public void update()
	{
		currentPlayer = getNextPlayer();
		currentPlayer.takeTurn();
	}
	public boolean checkGameOver() {
		if (currentState.equals(GAME_OVER_STATE)) {
			return true;
		}
		return false;
	}

	public IPlayer getPlayer(int index) {
		return players[index];
	}
	public IPlayer getNextPlayer(){
		return (currentPlayer.getId() != players[0].getId()) ? players[0] : players[1];
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		if (currentState != null) previousStates.add(currentState);
		this.currentState = currentState;
	}
}
