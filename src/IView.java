
public interface IView {
	//void displayState(State state);
	void displayMessage(String message);
	int chooseOption(int lowerBoundInclusive, int upperBoundInclusive);
	String enterString();
}
