import java.util.HashMap;

import org.junit.Test;

public class BrainTest {

	@Test
	public void test() {
		Brain.initialize(new State(3,5,7));
		HashMap<String, State> map = Brain.possibleStates;
		State s = Brain.getState("0,0,0");
		System.out.println(s.getAverage());
		System.out.println(s.getKey());
		}

}
