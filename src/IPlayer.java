
public interface IPlayer {
	
	void setPlayerName(String name);
	void setGame(Game game);
	void setView(IView view);
	void takeTurn();
	
	@Override
	String toString();
}
