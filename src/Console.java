import java.util.Scanner;

public class Console implements IView {	
	private Scanner input = new Scanner(System.in);
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
			String userChoice = enterString();
			if (userChoice.matches("[0-9]+")) {
				uChoice = Integer.parseInt(userChoice);
				valid = (uChoice >= lowerBound && uChoice <= upperBound);
			}
			if (!valid)
				displayMessage("That is an invalid input.");
		}
		return uChoice;
	}

	@Override
	public String enterString() {
		return input.nextLine();
	}

}
