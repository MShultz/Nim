import java.util.Scanner;

public class Console implements IView {
	private static final int STATE_SIZE = 3;
	private Scanner input = new Scanner(System.in);

	public void displayState(State currentState) {
		String currentStack;
		String[] stacks = currentState.getKey().split(",");
		for (int i = 0; i < STATE_SIZE; ++i) {
			currentStack = (i+1) + " |";
			for (int j = Integer.parseInt(stacks[i]); j > 0; --j) {
				currentStack += "X";
			}
			System.out.println(currentStack);
		}

	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public int chooseOption(int lowerBound, int upperBound) {
		boolean valid = false;
		int uChoice = -1;
		while (!valid) {
			displayMessage("Please input your choice.");
			String userChoice = input.nextLine();
			if(userChoice.matches("[0-9]+")){
				uChoice = Integer.parseInt(userChoice);
				valid = (uChoice >= lowerBound && uChoice <= upperBound);
			}
			if(!valid)
				displayMessage("That is an invalid input.");
		}
		return uChoice;
	}

	@Override
	public String enterString() {
		return input.nextLine();
	}

}
