package math;

public abstract class Position {
	private final int value;
	
	/**
	 * 
	 * @param value int number of this Position
	 */
	public Position(int value) {
		this.value = value;
	}
	
	public Position() {
		this(-1);
	}
	/**
	 * 
	 * @param No arguments needed
	 * @return the value of this Position as an int
	 */
	public int getValue() {
		return value;
	}

}
