
public class Main {

	public static void main(String[] args) {
		Brain.initialize(Game.GAME_START_STATE.getRows());
		Console view = new Console();
		Engine engine = new Engine(view);
		engine.start();
	}
}
