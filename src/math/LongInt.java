package math;

public class LongInt {
    private final int DIGIT_SIZE = 8;
    // DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
    // This will give a warning about raw types, but you can ignore it for this project
    @SuppressWarnings("rawtypes")
	//private final LongIntList list = new SLLLongIntList();
    
    // USE THIS LINE IN STEP 3
    private final LongIntList list = new ArrayLongIntList();
    
    private boolean isNegative;
        
	private LongInt(boolean sign) {
		setSign(sign);
	}
    
    public LongInt() {
		// TODO Clarify what should be done in this case
		this(true);
	}
	
	/**
	 * Initializes a new LongInt which represents the number in String s. String s is in the
	 * format: [-?][1-9][0-9]*
	 * @param s a number in the format [-?][1-9][0-9]*
	 */
    public LongInt(String s) {
    	/*
    	 * Originally as isNegative = false;
    	 * Clarify this scenario
    	 */
    	setSign(s);
    	
    	/*
    	 * Removes the sign from the input string s
    	 */
    	if(!getSign())
    		s = s.substring(1);
    	
    	if(s.length()%DIGIT_SIZE != 0) {
    		int leftoffCount = s.length()%DIGIT_SIZE;
    		String leftoff = s.substring(0, leftoffCount);	
    		list.insertFirst(Integer.parseInt(leftoff));
    		s = s.substring(leftoffCount);
    		
    	}
    	
    	if(s.length()%DIGIT_SIZE == 0 && !s.isEmpty()) {	
    		String[] split = s.split("(?<=\\G.{8})");
    		for(int i = 0; i < split.length;i++)
    			list.insertFirst(Integer.parseInt(split[i]));
    	}
    	
    }
	    
    /**
     * Prints the LongInt to standard output in format: [-?][1-9][0-9]*.
     * @param No arguments used
     * @return Nothing is returned
     */
    @SuppressWarnings("unchecked")
	public void output()  {
    	if(list.isEmpty())
    		return;
    	
    	if(isNegative)
    		System.out.print("-");
    	
    	Position p = list.last();
    	System.out.print(p.getValue());
    	
    	try {
    		p = list.before(p);
    	}catch(IllegalArgumentException e) {
    		return;
    	}
    	
    	while(!list.isFirst(p)) {
    		if(LongIntUtils.digits(p.getValue()) != DIGIT_SIZE)  {
    			int missingZeroes = DIGIT_SIZE - LongIntUtils.digits(p.getValue());
    			while(missingZeroes != 0) {
    				if(!list.isLast(p))
    					System.out.print("0");
    				missingZeroes--;
    			}	
    		}
    		System.out.print(p.getValue());
    		p = list.before(p);
    	}
    	/*
    	 * Fixed invisible zeroes for first node
    	 */
    	if(LongIntUtils.digits(p.getValue()) != DIGIT_SIZE)  {
			int missingZeroes = DIGIT_SIZE - LongIntUtils.digits(p.getValue());
			while(missingZeroes != 0) {
				System.out.print("0");
				missingZeroes--;
			}	
		}
    	
    	System.out.print(p.getValue());
    }
	
    private void setSign(boolean sign) {
    	if(sign)
    		isNegative = false;
    	else
    		isNegative = true;
    }
    
    private void setSign(String s) {
    	if(s.substring(0,1).equals("-"))
    		setSign(false);
    	else
    		setSign(true);
    }
    
    /**
     * Returns the sign of the LongInt (represented by a boolean isNegative)
     * @param No arguments used
     * @return boolean value represented by true as positive and false as negative
     */
    public boolean getSign() {
    	return isNegative ? false:true;
    }
    
    /**
     * Returns the number of decimal digits in the LongInt as an integer. This value has to
     * be computed dynamically
     * @param No arguments used
     * @return int value of number of digits in a LongInt
     */
    @SuppressWarnings("unchecked")
	public int getDigitCount() {
    	if (list.isEmpty())
    		return -1;
    	
    	int digitCount = 0;
    	Position p = list.first();
    	
    	while(!list.isLast(p)) {
       		if(LongIntUtils.digits(p.getValue()) != DIGIT_SIZE) {
    			//Unnecessary, but well
    			int missing = DIGIT_SIZE - LongIntUtils.digits(p.getValue());
    			digitCount = digitCount + (LongIntUtils.digits(p.getValue()) + missing);
    		}
    		else
    			digitCount+=LongIntUtils.digits(p.getValue());
    		p = list.after(p);
    	}
    	
    	digitCount+=LongIntUtils.digits(p.getValue());
    	
    	return digitCount;
    }
    
    /**
     * Return Boolean values indicating if the LongInt is equal to LongInt i.
     * @param i is the LongInt value to compare
     * @return boolean true for equality and false otherwise
     */
    @SuppressWarnings("unchecked")
	public boolean equalTo(LongInt i) {
    	if(this.list.size() != i.list.size()) 
    		return false; 
    	
    	if(this.getSign() != i.getSign())
    		return false;
    	
    	Position thisP = this.list.first();
    	Position otherP = i.list.first();
    	while((!list.isLast(thisP)) && (!i.list.isLast(otherP))) {
    		if(thisP.getValue() != otherP.getValue())
    			return false;
    		thisP = this.list.after(thisP);
    		otherP = i.list.after(otherP);
    	}
    	
    	if(thisP.getValue() != otherP.getValue())
    		return false;
    	
    	return true;
    }
    
    /**
     * Return Boolean values indicating if the LongInt is less than LongInt i.
     * @param i is the LongInt value to compare
     * @return boolean true if LongInt is less than i, false otherwise
     */
    @SuppressWarnings("unchecked")
	public boolean lessThan(LongInt i) {
    	if((this.isNegative) && (!i.isNegative)) 
    		return true;
    	
        else if((!this.isNegative) && (i.isNegative)) 
        	return false; 
    	
    	if(this.equalTo(i)) 
    		return false;
        
        if(this.list.size() < i.list.size()) {
        	if(this.isNegative && i.isNegative)
        		return false;
        	else 
        		return true;
        }
        	
        
        if(this.list.size() > i.list.size()) {
        	if(this.isNegative && i.isNegative)
        		return true;
        	else
        		return false;
        }
        
        
        Position thisP = this.list.last();
        Position otherP = i.list.last();
        
        /*
         * Up to this point, we can assume that they are not equal, their node size are equal,
         * and their signs are the same
         */
        while((!this.list.isFirst(thisP)) && (!i.list.isFirst(otherP))) {
        	//System.out.println("here");
        	if(thisP.getValue() > otherP.getValue()) {
        		if(this.isNegative && i.isNegative) {
                	return true;
        		}
        		else
        			return false;
        	}
        	
        	else if(thisP.getValue() < otherP.getValue()) {
        		if(this.isNegative && i.isNegative)
        			return false;
        		else {/*
                	thisP = this.list.before(thisP);
                	otherP = i.list.before(otherP);
                	continue;*/
        			return true;
        		}
        	}
        	
        	
        	thisP = this.list.before(thisP);
        	otherP = i.list.before(otherP);
        }
        
        if(thisP.getValue() > otherP.getValue()) {
        	if(this.isNegative && i.isNegative)
        		return true;
        	else
        		return false;
        }
        else if(thisP.getValue() < otherP.getValue()) {
    		if(this.isNegative && i.isNegative)
    			return false;
    		else
    			return true;
    	}
        
    	return true;
    }
    
    /**
     * Return Boolean values indicating if the LongInt greater than LongInt i.
     * @param i is the LongInt value to compare
     * @return boolean true if LongInt is greater than i, false otherwise
     */
    @SuppressWarnings("unchecked")
	public boolean greaterThan(LongInt i) {
    	if(this.lessThan(i))
    		return false;
    	if(this.equalTo(i))
    		return false;
    	if(this.list.size() > i.list.size()) {
    		if(this.isNegative && i.isNegative)
    			return false;
    		else
    			return true;
    	}
    		
    	if((!this.isNegative) && (i.isNegative))
    		return true;
    	else if((this.isNegative) && (!i.isNegative))
    		return false;
    	
    	Position thisP = this.list.last();
    	Position otherP = i.list.last();
    	
    	while((!this.list.isFirst(thisP)) && (i.list.isFirst(otherP))) {
    		if(otherP.getValue() > thisP.getValue()) {
    			if(this.isNegative && i.isNegative)
    				continue;
    			else
    				return false;
    		}
    		/*if(otherP.getValue() < thisP.getValue()) {
    			if(this.isNegative && i.isNegative)
    				return false;
    			else
    				continue;
    		}*/
    		thisP = this.list.before(thisP);
    		otherP = i.list.before(otherP);
    	}
    	
    	if(otherP.getValue() > thisP.getValue()) {
    		if(this.isNegative && i.isNegative)
    			return true;
    		else
    			return false;
    	}
    	
    	return true;
    }
    
    /**
     * Adds the LongInt to LongInt i and returns the result as a new LongInt. Must be
     * implemented separately from subtract, but add and subtract can call each other
     * when necessary.
     * @param i is the LongInt to be added to LongInt
     * @return LongInt representing the result of the addition
     */
    public LongInt add(LongInt i) {
        if((getSign() && !i.getSign()) || (!getSign() && i.getSign())) {
        	LongInt up = null;
            LongInt down = null;
            LongInt longInt = new LongInt();
            if(less(i)) {
            	up = i;
            	down = this;
            }
            else {
            	up = this;
            	down = i;
            }
            longInt = up.subtraction(down);
            if(!up.getSign())
            	longInt.setSign(false);
            else
            	longInt.setSign(true);
            return longInt;
            	
        }
        
        /*
         * At this point we can assume that both signs are equal. meaning it is safe to add
         */
       LongInt longInt = addition(i);;
      
       if(getSign() && i.getSign())
    	   longInt.setSign(true);
       else
    	   longInt.setSign(false);
      
       return longInt;
       
       
    }
    
    /**
     * Subtracts the LongInt i from the LongInt and returns the result as a new LongInt.
     * Must be implemented separately from add, but add and subtract can call each
     * other when necessary.
     * @param i is the LongInt to be subtracted from LongInt
     * @return LongInt representing the result from the subtraction
     */

	public LongInt subtract(LongInt i) {
        LongInt longInt = null;
    	
        if((getSign() && !i.getSign()) || (!getSign() && i.getSign())) {
        	longInt = addition(i);
        	if(getSign() && !i.getSign())
        		longInt.setSign(true);
        	else if(!getSign() && i.getSign())
        		longInt.setSign(false);
        	
        	return longInt;
        }
        
        LongInt up = null;
        LongInt down = null;
        
        if(getSign() && i.getSign()) {
        	up = getGreater(i);
        	down = getSmaller(i);
        	
        }
        else if(!getSign() && !i.getSign()) {
        	up = getSmaller(i);
        	down = getGreater(i);
        }
        
        if(equalTo(i))
        	return new LongInt("0");
        
        longInt = up.subtraction(down);
    	
        if(greaterThan(i)) {
    		longInt.setSign(true);
    	}
    	else if(lessThan(i)) {
    		longInt.setSign(false);
    	}
    	else {
    		longInt.setSign(true);
    	}
        
        return longInt;
        
    }
    
    /**
     * Multiplies the LongInt by LongInt i and returns the result as a new LongInt.
     * @param i is the LongInt to be multiplied with LongInt
     * @return LongInt representing the result from the multiplication
     */
    @SuppressWarnings("unchecked")
	public LongInt multiply(LongInt i) {
        LongInt top,bottom;
        
        if(getDigitCount() > i.getDigitCount()) {
        	top = this;
        	bottom = i;
        }
        else if (getDigitCount() < i.getDigitCount()){
        	top = i;
        	bottom = this;
        }
        else {
        	top = this;
        	bottom = i;
        }
        
        LongInt zero = new LongInt("0");
        if(top.equalTo(zero) || bottom.equalTo(zero))
        	return zero;
        
        Position up = top.list.first();
        Position down = bottom.list.first();
        LongInt[] ints = new LongInt[bottom.list.size()];
        
        
        
        int count = 0;
        while(!bottom.list.isLast(down)) {
        	LongInt tmp = new LongInt();
        	int carryover = 0;
        	int v2 = 0;
        	for(int j = 1; j <= count; j++) {
    			tmp.insertFront(0);
    		}
        	while(!top.list.isLast(up)) {
        		int[] multiplication = multiplication(up,down,carryover);
        		v2 = multiplication[0];
        		carryover = multiplication[1];
        		tmp.insertFront(v2);
        		up = top.list.after(up);      		
        	}
        	int[] multiplication = multiplication(up,down,carryover);
    		v2 = multiplication[0];
    		carryover = multiplication[1];
    		tmp.insertFront(v2);
    		if(carryover != 0)
    			tmp.insertFront(carryover);
    		
    		down = bottom.list.after(down);
    		up = top.list.first();
        	ints[count] = tmp;
        	count++;
        	
        }
       
        LongInt tmp = new LongInt();
    	int carryover = 0;
    	int v2 = 0;
    	
    	for(int j = 1; j <= count; j++) {
			tmp.insertFront(0);
		}
    	
    	up = top.list.first();
    	while(!top.list.isLast(up)) {
    		int[] multiplication = multiplication(up,down,carryover);
    		v2 = multiplication[0];
    		carryover = multiplication[1];
    		tmp.insertFront(v2);
    		up = top.list.after(up);
    		
    	}
    	
    	int[] multiplication = multiplication(up,down,carryover);
		v2 = multiplication[0];
		carryover = multiplication[1];
		tmp.insertFront(v2);
		if(carryover != 0)
			tmp.insertFront(carryover);
		ints[count] = tmp;
	
        LongInt sum = ints[0];
        for(int k = 0; k <= (ints.length-2); k++) {
        	sum = sum.add(ints[k+1]);
        }
        if((getSign() && !i.getSign()) || (!getSign() && i.getSign())) {
        	if (sum.list.size() == 1 && sum.list.first().getValue() == 0) {
        		sum.setSign(true);
        	}
        	else 
        		sum.setSign(false);
        }
        	
        	     	
    	return sum;
    }

    /**
     * Raises the LongInt to the power p (a regular integer) and returns the result as a new
     * LongInt. Note that no more than 2lg(p) calls to multiply are allowed.
     * @param p int value representing the power to raise the LongInt
     * @return LongInt representing the result from the power
     */
    public LongInt power(int p) {
    	return exponent(this,p);
    }
    
	public void printPositions() {
    	list.printPositions();
/*    	Position p = list.last();
    	System.out.print("Tail -> ");
    	while(!list.isFirst(p)) {
    		System.out.print(p.getValue() + " <- ");
    		p = list.before(p);
    	}
    	System.out.println(p.getValue() + " <- Head");*/
    }
    
    /**
     * Inserts i to front of this LongInt. Used as a buffer when doing arithmetics
     * @param i the int value to insert
     * @return Nothing is returned
     */
    private void insertFront(int i) {
    	list.insertLast(i);
    }    
	
    @SuppressWarnings("unchecked")
	private LongInt addition(LongInt i) {
    	LongInt longInt = new LongInt();
        Position thisP = this.list.first();
        Position otherP = i.list.first();
        int carryover = 0;
        
        while(!this.list.isLast(thisP) && !i.list.isLast(otherP)) {
     	   int sum = thisP.getValue() + otherP.getValue();
     	   sum = sum + carryover;
     	   carryover = LongIntUtils.overflow(sum);
     	   sum = LongIntUtils.underflow(sum);
     	   longInt.insertFront(sum);
     	   thisP = this.list.after(thisP);
     	   otherP = i.list.after(otherP);
        }
        													
        int sum = thisP.getValue() + otherP.getValue();    
        sum = sum + carryover; 							   
        carryover = LongIntUtils.overflow(sum);			        
        sum = LongIntUtils.underflow(sum);
        longInt.insertFront(sum);
        sum = 0;
       
        if(this.list.size() == i.list.size()) {
     	   if(carryover != 0) 
     		   longInt.insertFront(carryover);
        }
       
        else if(this.list.size() > i.list.size()) {
     	   thisP = this.list.after(thisP);
     	   while(!this.list.isLast(thisP)) {
     		   sum = thisP.getValue();
     		   sum = sum + carryover;
     		   carryover = LongIntUtils.overflow(sum);
     		   sum = LongIntUtils.underflow(sum);
     		   longInt.insertFront(sum);
     		   thisP = this.list.after(thisP);
     	   }
     	   
     	   sum = thisP.getValue();
     	   sum = sum + carryover;
     	   carryover = LongIntUtils.overflow(sum);
     	   sum = LongIntUtils.underflow(sum);
     	   longInt.insertFront(sum);
     	   if(carryover != 0) 
     		   longInt.insertFront(carryover);
        }
        else if (this.list.size() < i.list.size()){
     	   otherP = i.list.after(otherP);
     	   while(!i.list.isLast(otherP)) {
     		   sum = otherP.getValue();
     		   sum = sum + carryover;
     		   carryover = LongIntUtils.overflow(sum);
     		   sum = LongIntUtils.underflow(sum);
     		   longInt.insertFront(sum);
     		   otherP = i.list.after(otherP);
     	   }
     	   
     	   sum = otherP.getValue();
     	   sum = sum + carryover;
     	   carryover = LongIntUtils.overflow(sum);
     	   sum = LongIntUtils.underflow(sum);
     	   longInt.insertFront(sum);
     	   if(carryover != 0) 
     		   longInt.insertFront(carryover);
        }
        
       return longInt;

    }
    
    @SuppressWarnings("unchecked")
	private LongInt subtraction(LongInt i) {
        LongInt longInt = new LongInt();
        
        LongInt UP,DOWN;
    	UP = this;
    	DOWN = i;
    	boolean borrowed = false;
        int subtraction = 0;
       
        Position up,down;
        up = UP.list.first();
        down = DOWN.list.first();
        
        while(!DOWN.list.isLast(down)) {
        	int upValue = up.getValue();
        	int downValue = down.getValue();
        	
        	
        	if(borrowed && upValue > 0)
        		upValue--;
        	if(upValue < downValue) {
        		if(LongIntUtils.digits(upValue) != DIGIT_SIZE) {
        			int difference  = DIGIT_SIZE - LongIntUtils.digits(upValue);
        			while(difference != 0) {
        				upValue = LongIntUtils.append(9, upValue);
        				difference--;
        			}
        		}
        		else
        			upValue = LongIntUtils.append(1, upValue);
        		subtraction = upValue - downValue;
        		borrowed = true;
        	}
        	else {
        		subtraction = upValue - downValue;
        		borrowed = false;
        	}
        	
        	longInt.insertFront(subtraction);
        	up = UP.list.after(up);
        	down = DOWN.list.after(down);	
        }
        
        int upValue = up.getValue();
        int downValue = down.getValue();
        
        if(borrowed && upValue > 0)
        	upValue--;
        if(upValue < downValue) {
        	if(LongIntUtils.digits(upValue) != DIGIT_SIZE) {
    			int difference  = DIGIT_SIZE - LongIntUtils.digits(upValue);
    			while(difference != 0) {
    				upValue = LongIntUtils.append(9, upValue);
    				difference--;
    			}
    		}
    		else
    			upValue = LongIntUtils.append(1, upValue);
    		
        	subtraction = upValue - downValue;
    		borrowed = true;
        }
        else {
        	subtraction = upValue - downValue;
    		borrowed = false;
        }
        
        if(subtraction == 0) {
        	if(!UP.list.isLast(up)) {
        		longInt.insertFront(0);
        	}
        }
        else
        	longInt.insertFront(subtraction);
       
        if(!UP.list.isLast(up)) {
        	up = UP.list.after(up);
        	while(!UP.list.isLast(up)) {
        		upValue = up.getValue();
        		
        		if(borrowed && upValue > 0){
        			upValue--;
        			borrowed = false;
        		}
        		longInt.insertFront(upValue);
        		up = UP.list.after(up);
        	}
        	
        	upValue = up.getValue();
    		if(borrowed && upValue > 0){
    			upValue--;
    			borrowed = false;
    		}
    		if(upValue > 0)
    			longInt.insertFront(upValue);
    		
        }
        return longInt;
    }
    
    private LongInt getGreater(LongInt i) {
    	LongInt tmp = null;
    	if(greaterThan(i))
    		tmp = this;
    	else if(i.greaterThan(this))
    		tmp = i;
    	else if(equalTo(i))
    		tmp = this;
    	return tmp;
    }
    
    private LongInt getSmaller(LongInt i) {
    	LongInt tmp = null;
    	if(lessThan(i))
    		tmp = this;
    	else if (i.lessThan(this))
    		tmp = i;
    	else if(equalTo(i))
    		tmp = i;
    	return tmp;
    }
    
    private int[] multiplication(Position up, Position down, int carryover) {
    	int c1,c2,d1,d2,z1,z2,z3,v1,v2;
    	c1 = LongIntUtils.upperHalf(up.getValue());
		c2 = LongIntUtils.lowerHalf(up.getValue());
		d1 = LongIntUtils.upperHalf(down.getValue());
		d2 = LongIntUtils.lowerHalf(down.getValue());
		
		z1 = c1*d1;
		z3 = c2*d2;
		z2 = (c1+c2)*(d1+d2)-z3-z1;
		v1 = z1 + LongIntUtils.upperHalf(z2);
		v2 = z3 + LongIntUtils.lowerHalf(z2) * 10000;
		v2 = v2 + carryover;
		carryover = LongIntUtils.overflow(v2);
		carryover = v1 + carryover;
		v2 = LongIntUtils.underflow(v2);
		int[] tmp = {v2,carryover};
		return tmp;
    }
    
    private LongInt exponent(LongInt i, int power) {
    	if(power == 1)
    		return i;
    	if(power%2 == 0) 
    		return exponent(i.multiply(i), power/2);
    	return i.multiply(exponent(i.multiply(i),power/2));
    	
    		
    }
    
    @SuppressWarnings("unchecked")
	private boolean less(LongInt i) {
    	if(this.equalTo(i)) 
    		return false;
        
        if(this.list.size() < i.list.size()) {
        	return true;
        }
        	
        
        if(this.list.size() > i.list.size()) {
        	return false;
        }
        
        
        Position thisP = this.list.last();
        Position otherP = i.list.last();
        
        /*
         * Up to this point, we can assume that they are not equal, their node size are equal,
         * and their signs are the same
         */
        while((!this.list.isFirst(thisP)) && (!i.list.isFirst(otherP))) {
        	//System.out.println("here");
        	if(thisP.getValue() > otherP.getValue()) {
        		return false;
        	}
        	
        	else if(thisP.getValue() < otherP.getValue()) {
        		return true;
        	}
        	
        	
        	thisP = this.list.before(thisP);
        	otherP = i.list.before(otherP);
        }
        
        if(thisP.getValue() > otherP.getValue()) {
        	return false;
        }
        else if(thisP.getValue() < otherP.getValue()) {
    			return true;
    	}
        
    	return false;

    }
    
    @SuppressWarnings("rawtypes")
	public String getImplementationName() {
    	Class cl = list.getClass();
    	return cl.getName();
    }

}

