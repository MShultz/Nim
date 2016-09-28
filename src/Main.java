
public class Main {

	public static void main(String[] args) {
		TempViewClass view = new TempViewClass();
		Engine engine = new Engine(view);
		engine.start();
	}

}
