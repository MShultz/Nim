
public interface IPlayer {
	void setPlayerName();
	void setGame(Game game);
	void takeTurn();
	@Override
	String toString();
}
