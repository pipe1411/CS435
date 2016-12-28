package math;

public class LongIntUtils {

	/**
	 * Returns the overflow digit (9th (most significant) digit of an integer)
	 * @param t is the int value
	 * @return int containing the 9th most significant digit. returns zero when no overflow
	 */
	public static int overflow(int t) {
		if(t <= 99999999)
			return 0;
			/*
			 * Removed per TA requirements. Function must return 0 instead of an error.
			 * throw new IllegalArgumentException("VALUE MUST CONTAIN 9 DIGITS");
			 */
			
			
		return t/100000000;
	}
	
	/**
	 * Returns the underflow digits (1st – 8th least significant digits in an integer
	 * @param t is the int value
	 * @return int containing the first 8 digits of an integer
	 */
	public static int underflow(int t) {
		if(t <= 99999999)
			return t;
		return t%100000000;		
	}
	
	/**
	 * Returns the 4 most significant digits of an 8 digit integer.
	 * @param t is the int value
	 * @return int containing the 4 most significant digits in t
	 */
	public static int upperHalf(int t) throws IllegalArgumentException{
/*		if(t > 99999999 || t <= 9999999 )
			throw new IllegalArgumentException("VALUE MUST HAVE 8 DIGIST");
*/		return t/10000;
	}
	
	/**
	 * Returns the 4 least significant digits of an 8 digit integer.
	 * @param t is the int value
	 * @return int containing the 4 least significant digits in t
	 */
	public static int lowerHalf(int t) throws IllegalArgumentException{
/*		if(t > 99999999 || t <= 9999999 )
			throw new IllegalArgumentException("VALUE MUST HAVE 8 DIGIST");
*/		return t%10000;
	}
	
	/**
	 * Returns the number of decimal digits in a regular integer as an integer
	 * @param t is the int value
	 * @return int containing the number of decimal digits
	 */
	public static int digits(int t) {
		if(t < 0)
			throw new IllegalArgumentException("VALUE MUST NOT BE NEGATIVE: " + t);
		
		if(t == 0)
			return 1;
		
		int length = 0;
		
		for(length = 0; t > 0; length++)
			t = t/10;
		
		return length;
	}
	
	public static int append(int a, int b) {		
		if(b == 0)
			a = a*10;
		else {
			int c = b;
			while(c > 0) {
				c = c/10;
				a = a*10;
			}
		}
		
		return a+b;		
	}

}
