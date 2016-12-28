package math;

public class SLLLongIntList implements LongIntList<SLLNode>{
	private SLLNode head;
	private SLLNode tail;
	
	
	public SLLLongIntList() {
		head = new SLLNode();
		tail = new SLLNode();
		head.setNext(tail);
		tail.setNext(head);
	}
	
	@Override
	public void insertFirst(int value) {
		SLLNode node = new SLLNode(value);
		/*
		 * The case when there are no nodes in the list
		 */
		if(head.getNext() == tail && tail.getNext() == head) {
			node.setNext(null);
			head.setNext(node);
			tail.setNext(node);
			//size++;
			return;
		}
	
		/*
		 * New node points to where the head was pointing
		 * then, make head point to the new node
		 */
		node.setNext(head.getNext());
		head.setNext(node);
		//size++;
	}

	@Override
	public void insertLast(int value) {
		SLLNode node = new SLLNode(value);
		/*
		 * The case when there are no nodes in the list
		 */
		if(head.getNext() == tail && tail.getNext() == head) {
			insertFirst(value);
			return;
		}
		
		tail.getNext().setNext(node);
		node.setNext(null);
		tail.setNext(node);
		//size++;
		
	}

	@Override
	public SLLNode first() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return head.getNext();
	}

	@Override
	public SLLNode last() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return tail.getNext();
	}

	@Override
	public boolean isFirst(SLLNode p) {
		return head.getNext() == p ? true:false;
	}

	@Override
	public boolean isLast(SLLNode p) {
		return tail.getNext() == p ? true:false;
	}

	@Override
	public SLLNode before(SLLNode p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		
		if(head.getNext() == p)
			throw new IllegalArgumentException("Position p is first position");
		
		SLLNode node = first();
		while(node.getNext() != null) {
			if(node.getNext() == p)
				return node;
			node = node.getNext();
		}		
		return null;
	}

	@Override
	public SLLNode after(SLLNode p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		
		if(tail.getNext() == p)
			throw new IllegalArgumentException("Position p is last postition");
		
		SLLNode node = head.getNext();
		while(node.getNext() != null){
			if(node == p) 
				return node.getNext();
			node = node.getNext();
		}
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head.getNext() == tail ? true:false;
	}

	@Override
	public int size() {
		if(isEmpty())
			return 0;
		
		SLLNode node = head.getNext();
		int size = 0;
		while(node != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}
	
	@Override
	public void printPositions() {
    	SLLNode node = last();
    	System.out.print("Tail -> ");
    	while(!isFirst(node)) {
    		System.out.print(node.getValue() + " <- ");
    		node = before(node);
    	}
    	System.out.println(node.getValue() + " <- Head");
    }
	
	
	public void removeLast() {
		SLLNode last = tail.getNext();
		SLLNode before = before(last);
		before.setNext(null);
		tail.setNext(before);
	}
	
	

}
