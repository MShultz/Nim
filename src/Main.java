
public class Main {

	public static void main(String[] args) {
		Brain.initialize(Game.GAME_START_STATE.getRows());
		Program program = new Program();
		program.run();
	}
}
