
public class Game {

	private static final State GAME_START_STATE = new State(3, 5, 7);
	private static final State GAME_OVER_STATE = new State(0, 0, 0);

	private IPlayer[] players = new IPlayer[2];
	private State currentState;

	public Game(IPlayer player1, IPlayer player2) {
		players[0] = player1;
		players[1] = player2;
		currentState = GAME_START_STATE;
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

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
}
