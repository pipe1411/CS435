package math;

public class SLLNode extends Position {
	
	private SLLNode next;
	
	/**
	 * Creates a new new SLLNode
	 * @param value is the int value of this SLLNode
	 */
	public SLLNode(int value) {
		super(value);
	}
	
	/**
	 * Creates a new SLLNode 
	 * @param No arguments needed (designed for head and tail)
	 */
	public SLLNode() {
		super();
	}
	
	/**
	 * Returns the next node
	 * @param No arguments used
	 * @return SLLNode 
	 */
	public SLLNode getNext() {
		return next;
	}
	
	/**
	 * Points this SLLNode to the next node
	 * @param next is the node to be associated with this node
	 * @return Nothing is returned
	 */
	public void setNext(SLLNode next) {
		this.next = next;
	}

}
