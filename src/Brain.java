import java.util.HashMap;

public class Brain {
	private static final int STARTING_ROW = 0;
	private static final int ENDING_ROW = 2;
	static HashMap<String, State> possibleStates = new HashMap<String, State>();

	public static void initialize(State gameStartState) {
		for (int i = 0; i <= gameStartState.getRow(STARTING_ROW); ++i) {
			for (int j = 0; j <= gameStartState.getRow(STARTING_ROW + 1); ++j) {
				for (int k = 0; k <= gameStartState.getRow(ENDING_ROW); ++k) {
					possibleStates.put(i + "," + j + "," + k, new State(i, j, k));
				}
			}
		}
	}

	public static State getState(String key) {
		return possibleStates.get(key);
	}

	public static String[] getPossibleStates(State currentState){
		int count = 0;
		int[] rows = currentState.getRows();
		int totalPossible = (rows[STARTING_ROW] + rows[STARTING_ROW +1] + rows[ENDING_ROW]);
		String[] possibles = new String[totalPossible];
		
		for(int i = rows[STARTING_ROW]-1; i >= 0; --i){
			possibles[count] = i +"," + rows[STARTING_ROW +1] + "," + rows[ENDING_ROW];
			++count;
		}
		for(int j = rows[STARTING_ROW+1]-1; j >= 0; --j){
			possibles[count] = rows[STARTING_ROW] +"," + j + "," + rows[ENDING_ROW];
			++count;
		}
		for(int k = rows[ENDING_ROW]-1; k >= 0; --k){
			possibles[count] = rows[STARTING_ROW] +"," + rows[STARTING_ROW +1] + "," + k;
			++count;
		}
		return possibles;
	}
	
}
