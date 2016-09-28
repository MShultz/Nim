/**
 * Created by Greymoon on 9/28/2016.
 */
public class Human implements IPlayer {
	private static final int  FIRST_ROW = 1;
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
		view.displayState(game.getCurrentState());
		view.displayMessage("What row would you like to choose: ");
		int response = view.chooseOption(FIRST_ROW, FINAL_ROW);
		
	}

	@Override
	public void setView(IView view) {
		this.view = view;
	}
}
