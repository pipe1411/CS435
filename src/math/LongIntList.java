package math;

public interface LongIntList<P extends Position> {
	
	/**
	 * Adds a new node with value v at front of the list
	 * @param value int value of the new node
	 * @return Nothing is returned
	 */
	public void insertFirst(int value);
	
	/**
	 * Adds a new node with value v at the end of the list
	 * @param int value of the new node
	 * @return Nothing is returned
	 */
	public void insertLast(int value);
	
	/**
	 * Returns first Position of the list
	 * @param No arguments needed
	 * @return P the first position in the list
	 */
	public P first();
	
	/**
	 * Returns last Position of the list
	 * @param No arguments needed
	 * @return P the last position in the list
	 */
	public P last();
	
	/**
	 * Determines if Position p is the first position of the list
	 * @param the element to be compared with the first element in the list
	 * @return boolean true if it's first, false otherwise
	 */
	public boolean isFirst(P p);
	
	/**
	 * Determines if Position p is the last position of the list
	 * @param the element to be compared with the last element in the list
	 * @return boolean true if it's the last, false otherwise
	 */
	public boolean isLast(P p);
	
	/**
	 * Returns the Position before Position p (error if p is first position)
	 * @param the element to be compared
	 * @return P the element before p
	 * @exception IllegalArgumentException if p is first position
	 */
	public P before(P p);
	
	/**
	 * Returns the Position after Position p (error if p is the last position)
	 * @param the element to be compared
	 * @return P the element after p
	 * @exception IllegalArgumentException if o is last position
	 */
	public P after(P p);
	
	/**
	 * Returns Boolean value indicating if the list has no nodes
	 * @param No arguments needed
	 * @return boolean true if the list is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of positions in the list as an integer
	 * @param No arguments needed
	 * @return int value indicating the number of positions in the list
	 */
	public int size();
	
	public void printPositions();
}
