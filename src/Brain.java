import java.util.HashMap;

public class Brain {
	private static final int STARTING_ROW = 0;
	private static final int MIDDLE_ROW = 1;
	private static final int ENDING_ROW = 2;
	static HashMap<String, State> possibleStates = new HashMap<String, State>();

	public static void initialize(int[] gameStartState) {
		for (int i = 0; i <= gameStartState[STARTING_ROW]; ++i) {
			for (int j = 0; j <= gameStartState[MIDDLE_ROW]; ++j) {
				for (int k = 0; k <= gameStartState[ENDING_ROW]; ++k) {
					possibleStates.put(i + "," + j + "," + k, new State(i, j, k));
				}
			}
		}
	}

	public static State getState(String key) {
		return possibleStates.get(key);
	}

	public static String[] getPossibleStates(int[] rows){
		int count = 0;
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

	public static void assignGameAverages(State[] states){
		double numberOfStates = states.length;
		double numberOfBadStates = (int) Math.ceil((double) numberOfStates / 2);
		double numberOfGoodStates = ((numberOfStates % 2 == 0) ? numberOfBadStates : numberOfBadStates - 1);

		int badStateCount = (int) numberOfBadStates;
		for(int i = (int) numberOfStates - 1; i >= 0; i-=2)
		{
			states[i].setAverage(-badStateCount/numberOfBadStates);
			--badStateCount;
		}

		int GoodStateCount = (int) numberOfGoodStates;
		for(int i = (int) numberOfStates - 2; i >= 0; i-=2)
		{

			states[i].setAverage(GoodStateCount/numberOfGoodStates);
			--GoodStateCount;
		}
		for (State state : states) {
			System.out.println(state.getKey() + " Average: " + state.getAverage());
		}
		evaluateAverage(states);
	}
	
	public static void evaluateAverage(State[] gameHistory){
		for(State current: gameHistory){
			State history = possibleStates.get(current.getKey());
			history.setAverage((current.getAverage()+history.getAverage())/2);
		}
	}

}
