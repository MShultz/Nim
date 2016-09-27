
public class State {
	private static final int DEFAULT_VALUE = 0;
	private String key;
	private double average;

	public State() {
		key = "-";
		average = DEFAULT_VALUE;
	}

	public State(int stackOne, int stackTwo, int stackThree) {
		key = stackOne + "," + stackTwo + "," + stackThree;
		average = DEFAULT_VALUE;
	}

	public String getKey() {
		return key;
	}
	public double getAverage(){
		return average;
	}
	public void setAverage(double average){
		this.average = average;
	}
}
