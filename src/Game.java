import java.util.ArrayList;

public class Game {

	private static final State GAME_START_STATE = new State(3, 5, 7);
	private static final State GAME_OVER_STATE = new State(0, 0, 0);

	private ArrayList<State> previousStates = new ArrayList<State>();
	private IPlayer[] players = new IPlayer[2];
	private IPlayer currentPlayer;
	private State currentState;
	private int turnCount = 0;

	public Game(IPlayer player1, IPlayer player2, IView view) {
		players[0] = player1;
		players[1] = player2;
		for (IPlayer player : players) {
			player.setGame(this);
			player.setView(view);
		}
		currentState = GAME_START_STATE;
		currentPlayer = players[RandomSingleton.RandomIntInRange(0,1)];
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
		return (currentPlayer.equals(players[0])) ? players[1] : players[0];
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		if (currentState != null) previousStates.add(currentState);
		this.currentState = currentState;
	}
}
