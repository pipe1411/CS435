package math;

public class ArrayLongIntList implements LongIntList<ArrayEntry> {
    private final int ENTRIES_INITIAL_SIZE = 100;
	private int n;
    private ArrayEntry [] entries;
    
    public ArrayLongIntList() {
    	n = 0;
    	entries = new ArrayEntry[ENTRIES_INITIAL_SIZE];
    }

	@Override
	public void insertFirst(int value) {
		if((entries.length - n) == 1)
			resize();
		
		if(isEmpty()) {
			entries[0] = new ArrayEntry(value,0);
			n++;
			return;
		}
		
		shiftEntries(size());
		entries[0] = new ArrayEntry(value,0);
		n++;	
	}
	
	private void shiftEntries(int index) {
		if(index == 0)
			return;
		
		entries[index] = entries[index - 1];
		entries[index].setIndex(index);
		
		index--;
		shiftEntries(index);		
	}

	@Override
	public void insertLast(int value) {
		if((entries.length - size()) == 1)
			resize();
		
		if(size() > 0)
			entries[size()] = new ArrayEntry(value,size());
		else
			entries[0] = new ArrayEntry(value,0);
		n++;
	}

	@Override
	public ArrayEntry first() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return entries[0];
	}

	@Override
	public ArrayEntry last() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return entries[size() - 1];
	}

	@Override
	public boolean isFirst(ArrayEntry p) {
		return entries[0] == p ? true:false;
	}

	@Override
	public boolean isLast(ArrayEntry p) {
		return entries[size() - 1] == p ? true:false;
	}

	@Override
	public ArrayEntry before(ArrayEntry p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
	
		if(entries[0] == p)
			throw new IllegalArgumentException("Position p is first position");
		
		return entries[p.getIndex() - 1];
	}

	@Override
	public ArrayEntry after(ArrayEntry p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		
		if(entries[size() - 1] == p)
			throw new IllegalArgumentException("Position p is last position");
	
		return entries[p.getIndex() + 1];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0 ? true:false;
	}

	@Override
	public int size() {
		return n;
	}
	
	@Override
	public void printPositions() {
    	ArrayEntry p = last();
    	//System.out.print("Tail -> ");
    	while(!isFirst(p)) {
    		System.out.print("Value: " + p.getValue() + " Index: " + p.getIndex() + " | ");
    		p = before(p);
    	}
    	System.out.println("Value: " + p.getValue() + " Index: " + p.getIndex() + " | ");
    }
	
	
	private void resize() {
		ArrayEntry[] tmp = new ArrayEntry[entries.length + 10];
		//entries[n].setNext(tmp);
		for(int i = 0; i < entries.length; i++)
			tmp[i] = entries[i];
		entries[n] = tmp[0];
	}

}
