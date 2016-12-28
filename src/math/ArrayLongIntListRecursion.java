package math;

public class ArrayLongIntListRecursion implements LongIntList<ArrayNode> {
	
	private ArrayNode[] arrayNodes;
	private int aSize = 0;
	
	
	public ArrayLongIntListRecursion() {
		arrayNodes = new ArrayNode[100];
	}
	
	@Override
	public void insertFirst(int value) {
		if((arrayNodes.length - size()) == 1) 
			resize();
		
		if(isEmpty()) {
			arrayNodes[0] = new ArrayNode(value);
			aSize++;
			return;
		}
		
		for(int i = size(); i >= 1; i--) {
			arrayNodes[i] = arrayNodes[i-1];
		}
		arrayNodes[0] = new ArrayNode(value);
		aSize++;
	}

	@Override
	public void insertLast(int value) {
		int size = size();
		
		if((arrayNodes.length - size) == 1)
			resize();
		
		size = size();
		
		if(size > 0)
			arrayNodes[size()] = new ArrayNode(value);
		else
			arrayNodes[0] = new ArrayNode(value);
		aSize++;
	}

	@Override
	public ArrayNode first() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return arrayNodes[0];
	}

	@Override
	public ArrayNode last() {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		return arrayNodes[size() - 1];
	}

	@Override
	public boolean isFirst(ArrayNode p) {
		return arrayNodes[0] == p ? true:false;
	}

	@Override
	public boolean isLast(ArrayNode p) {
		return arrayNodes[size() - 1] == p ? true:false;
	}

	@Override
	public ArrayNode before(ArrayNode p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		
		if(arrayNodes[0] == p)
			throw new IllegalArgumentException("ArrayNode p is first ArrayNode");
		
		return before(p,size()-1);
	}
	
	private ArrayNode before(ArrayNode p, int index) {
		if(index == 0)
			return null;
		
		if(arrayNodes[index] == p)
			return arrayNodes[index - 1];
		index-=1;
		return before(p,index);
	}

	@Override
	public ArrayNode after(ArrayNode p) {
		if(isEmpty())
			throw new IllegalArgumentException("Structure is empty");
		
		if(isLast(p))
			throw new IllegalArgumentException("ArrayNode p is last ArrayNode");
		
		return after(p,0,size());
	}
	
	/**
	 * 
	 * @param p returns the ArrayNode after position p
	 * @param index array index to begin search
	 * @param size size of the array
	 * @return ArrayNode returns the ArrayNode after p. If no match is found, then null is returned.
	 */
	private ArrayNode after(ArrayNode p, int index, int size) {
		if(index == (size-1))
			return null;
		
		if(arrayNodes[index] == p)
			return arrayNodes[index+1];
		
		index+=1;
		return after(p,index,size);
	}

	@Override
	public boolean isEmpty() {
		return size() == 0 ? true:false;
	}

	@Override
	public int size() {
/*		int count = 0;
		for(ArrayNode p : arrayNodes) {
			if(p == null)
				return count;
			count++;
		}
		return count;*/
		return aSize;
		//return count(0);
	}
	
	private int count(int index) {
		if(arrayNodes[index] == null)
			return 0;
		
		if(index == arrayNodes.length)
			return 1;
		
		index+=1;
		return 1 + count(index);
	}
	
	private void resize() {
		ArrayNode[] tmp = new ArrayNode[arrayNodes.length + 10];
		for(int i = 0; i < arrayNodes.length; i++)
			tmp[i] = arrayNodes[i];
		arrayNodes = tmp;
	}
	
	@Override
	public void printPositions() {
		
	}

}
