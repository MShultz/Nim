public class State {
	private static final int DEFAULT_VALUE = 0;
	private static final int DEFAULT_AVERAGE = 0;
	private static final int LOWEST_AVERAGE = -1;
	private static final int STATE_SIZE = 3;
	private String key;
	private double average;
	private int[] rows;
	
	public State() {
		key = "-";
		rows = new int[]{DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE};
		average = LOWEST_AVERAGE;
	}

	public State(int stackOne, int stackTwo, int stackThree) {
		key = stackOne + "," + stackTwo + "," + stackThree;
		rows = new int[]{stackOne, stackTwo, stackThree};
		average = DEFAULT_AVERAGE;
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
	public int getRow(int rowNum){
		return rows[rowNum];
	}
	public int[] getRows(){
		return rows;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String currentStack = "";
		int[] stacks = getRows();
		for (int i = 0; i < STATE_SIZE; ++i) {
			currentStack += (i + 1) + " |";
			for (int j = stacks[i]; j > 0; --j) {
				currentStack += "X";
			}
			currentStack += "\n";
		}
		
		return currentStack;
	}
}
