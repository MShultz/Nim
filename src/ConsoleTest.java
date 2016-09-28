import static org.junit.Assert.*;

import org.junit.Test;

public class ConsoleTest {

	@Test
	public void test() {
		Console console = new Console();
		State stateOne = new State(3,5,7);
		
		console.displayState(stateOne);
		console.chooseOption(1, 3);
		
	}

}
