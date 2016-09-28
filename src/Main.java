
public class Main {

	public static void main(String[] args) {
		Console view = new Console();
		Engine engine = new Engine(view);
		engine.start();
	}

}
