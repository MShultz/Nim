
public interface IView {
	public void displayState(State currentState);
	public void displayMessage(String message);
	public int chooseOption(int lowerBound, int upperBound);
	
}
