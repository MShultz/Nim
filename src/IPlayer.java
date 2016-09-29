
public interface IPlayer {
	
	void setPlayerName(String name);
	void setGame(Game game);
	void setView(IView view);
	int getId();
	void takeTurn();
	void lose();
	@Override
	String toString();
}
