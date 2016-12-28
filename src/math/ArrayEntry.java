package math;


public class ArrayEntry extends Position {

    // This entry's index in the array.
    private int index;
    //private ArrayEntry[] next;

    public ArrayEntry(int value, int index) {
        super(value);

        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
 /*   public void setNext(ArrayEntry[] next) {
    	this.next = next;
    }
    
    public ArrayEntry[] getNext() {
    	return next;
    }*/
}

