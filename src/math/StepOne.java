package math;

import java.io.FileWriter;
import java.io.IOException;

public class StepOne {
	private static String A = "2222";
	private static String B = "99999999";
	private static String C = "-246813575732";
	private static String D = "180270361023456789";
	private static String E = "1423550000000010056810000054593452907711568359";
	private static String F = "-350003274594847454317890";
	private static String G = "29302390234702973402973420937420973420937420937234872349872934872893472893749287423847";
	private static String H = "-98534342983742987342987339234098230498203894209928374662342342342356723423423";
	private static String I = "8436413168438618351351684694835434894364351846843435168484351684684315384684313846813153843135138413513843813513813138438435153454154515151513141592654543515316848613242587561516511233246174561276521672162416274123076527612";
	private static String[] titleRow = {"","A","B","C","D","E","F","G","H","I"};
	private static String[] nodeTraversalTime = new String[10];
	private static String[] outputTime = new String[10];
	private static String[] getSignTime = new String[10];
	private static String[] digitCountTime = new String[10];
	private static LongInt[] longIntArray = new LongInt[9];
	private static final String[] LETTER_MAP = {"A","B","C","D","E","F","G","H","I"};
	private final static String EQUAL = "IS EQUAL TO";
	private final static String NOT_EQUAL = "IS NOT EQUAL TO";
	private final static String LESS = "IS LESS THAN";
	private final static String NOT_LESS = "IS NOT LESS THAN";
	private final static String GREATER = "IS GREATER THAN";
	private final static String NOT_GREATER = "IS NOT GREATER THAN";
	private static Long start;
	private static String time;
	private static FileWriter writer;
	private static int counter = 0;
	
	/**
	 * Begins the test case
	 * @param No arguments needed
	 * @return Nothing is returned
	 * @throws IOException 
	 */
	public static void begin(FileWriter write) throws IOException {
		writer = write;
		String[] numbers = {A,B,C,D,E,F,G,H,I};
		initializeLongIntArray(numbers);
		traversalLongIntprintSignDigitCount();
		utilityMethods();
		comparison();
	}
	
	/**
	 * Prints the sign of the LongInt (+|-)
	 * @param num the LongInt number 
	 * @return Nothing is returned
	 */
	private static void printSign(LongInt num) {
		if(num.getSign())
			System.out.println("+");
		else
			System.out.println("-");
	}
	/**
	 * Initializes the longIntArray that will contain all of A-I LongInt's
	 * @param numbers the set of all numbers represented as Strings
	 * @return Nothing is returned
	 * @throws IOException 
	 */
	private static void initializeLongIntArray(String[] numbers) throws IOException{
		
		String[] initTime = new String[LETTER_MAP.length + 1];
		initTime[0] = "Initialization";
		for(int i = 0; i < longIntArray.length; i++) {
			startTrial();
			longIntArray[i] = new LongInt(numbers[i]);
			endTrial();
			initTime[i+1] = time;
		}
		titleRow[0] = longIntArray[0].getImplementationName();
		CSVWriter.writeLine(writer, titleRow);
		CSVWriter.writeLine(writer, initTime);
	}
	
	/**
	 * For each Long Integer traverse it’s LongIntList and print the value stored at each position (put a space
	 * between each node). This test is to make sure each node stores at most 8 digits. Print each Long Integer 
	 * to standard output using output(). Print the sign and number of digits of each Long Integer. 
	 * @param num The LongInt object to apply on traversal, output,sign, and digit count
	 * @return Nothing is returned
	 */
	private static void testCase(LongInt num) {
		//TODO revert back
		startTrial();
		num.printPositions();
		endTrial();
		nodeTraversalTime[counter] = time;
		System.out.print("output(): ");
		startTrial();
		num.output();
		endTrial();
		outputTime[counter] = time;
		System.out.print("\nSign: ");
		startTrial();
		printSign(num);
		endTrial();
		getSignTime[counter] = time;
		startTrial();
		System.out.println("Digit Count: "+ num.getDigitCount() + "\n\n\n");
		endTrial();
		digitCountTime[counter] = time;
		
	}
	/**
	 * Stores the value of A and B in regular ints and applies all of the utility methods. 
	 * @param No arguments needed
	 * @return Nothing is returned
	 */
	private static void utilityMethods() {
		int a = Integer.valueOf(A);
		int b = Integer.valueOf(B);
		
		System.out.println("*******************");
		System.out.println("**UTILITY METHODS**");
		System.out.println("*******************\n");
		
		System.out.println("OVERFLOW");
		try {
		 System.out.println("A overflow: " + LongIntUtils.overflow(a));
		}catch(IllegalArgumentException e) {
			System.out.println("A " + e.getMessage());
		}
		try {
		 System.out.println("B overflow: " + LongIntUtils.overflow(b));
		}catch(IllegalArgumentException e) {
			System.out.println("B "+e.getMessage());
		}
		
		System.out.println("\nUNDERFLOW");
		System.out.println("A underflow: " + LongIntUtils.underflow(a));
		System.out.println("B underflow: " + LongIntUtils.underflow(b));
		
		System.out.println("\nUPPERHALF");
		try {
			System.out.println("A upperhalf: " + LongIntUtils.upperHalf(a));
		}catch(IllegalArgumentException e) {
			System.out.println("A " + e.getMessage());
		}
		try{
			System.out.println("B upperhalf: " + LongIntUtils.upperHalf(b));
		}catch(IllegalArgumentException e) {
			System.out.println("B " + e.getMessage());
		}
		
		System.out.println("\nLOWERHALF");
		try {
			System.out.println("A lowerhalf: " + LongIntUtils.lowerHalf(a));
		}catch(IllegalArgumentException e) {
			System.out.println("A " + e.getMessage());
		}
		try{
			System.out.println("B lowerhalf: " + LongIntUtils.lowerHalf(b));
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nDIGITS");
		System.out.println("A digits: " + LongIntUtils.digits(a));
		System.out.println("B digits: " + LongIntUtils.digits(b) + "\n");
	}
	
	/**
	 * For each Long Integer compare it to A-I using equalTo, lessThan, greaterThan (i.e., apply all three method 
	 * pair-wise, including on itself).
	 * @param No arguments needed
	 * @return Nothing is returned
	 * @throws IOException 
	 */
	private static void comparison() throws IOException {
		String[] equalToTime = new String[10];
		equalToTime[0] = "equalTo()";
		String[] lessThanTime = new String[10];
		lessThanTime[0] = "lessThan()";
		String[] greaterThanTime = new String[10];
		greaterThanTime[0] = "greaterThan()";
		
		System.out.println("**********************");
		System.out.println("**COMPARISON METHODS**");
		System.out.println("**********************\n");
		
		System.out.println("Comparison is performed in the following order:");
		System.out.println("equalTo()");
		System.out.println("lessThan()");
		System.out.println("greaterThan()\n");
		
		for(int a = 0; a < longIntArray.length; a++) {
			for(int b = 0; b < longIntArray.length; b++) {
				System.out.println(LETTER_MAP[a] + " Compared to " + LETTER_MAP[b]);
				startTrial();
				if(longIntArray[a].equalTo(longIntArray[b])) {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],EQUAL,"==",longIntArray[a],longIntArray[b]);
				}
				else {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],NOT_EQUAL,"!=",longIntArray[a],longIntArray[b]);
				}
				endTrial();
				if(LETTER_MAP[a].equals(LETTER_MAP[b]))
					equalToTime[a+1] = time;
				startTrial();
				if(longIntArray[a].lessThan(longIntArray[b])) {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],LESS,"<",longIntArray[a],longIntArray[b]);
				}
				else {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],NOT_LESS,"!<",longIntArray[a],longIntArray[b]);
				}
				endTrial();
				if(LETTER_MAP[a].equals(LETTER_MAP[b]))
					lessThanTime[a+1] = time;
				startTrial();
				if(longIntArray[a].greaterThan(longIntArray[b])) {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],GREATER,">",longIntArray[a],longIntArray[b]);
				}
				else {
					comparisonMessage(LETTER_MAP[a],LETTER_MAP[b],NOT_GREATER,"!>",longIntArray[a],longIntArray[b]);
				}
				endTrial();
				if(LETTER_MAP[a].equals(LETTER_MAP[b]))
					greaterThanTime[a+1] = time;
				System.out.println();
				
			}
			System.out.println();
			
		}
		CSVWriter.writeLine(writer, equalToTime);
		CSVWriter.writeLine(writer, lessThanTime);
		CSVWriter.writeLine(writer, greaterThanTime);
	}
	
	/**
	 * Prints the result of the comparison
	 * @param a The letter to the left of the operator
	 * @param b The letter to the right of the operator
	 * @param message Equality message to be printed
	 * @param symbol The operator to be printed
	 * @param numA LongInt to the left of operator
	 * @param numB LongInt to the right of operator
	 * @return Nothing is returned
	 */
	private static void comparisonMessage(String a, String b, String message, String symbol,LongInt numA, LongInt numB) {
		System.out.print(a + " " + message + " " + b + " ");
		System.out.println();
	}
	/**
	 * Calls each LongInt and performs traversal,output,sign, and digit count on each LongInt
	 * @param No arguments needed
	 * @return Nothing is returned
	 * @throws IOException 
	 */
	private static void traversalLongIntprintSignDigitCount() throws IOException {
		System.out.println("*****************************************");
		System.out.println("**NODE OUTPUT,OUTPUT(),SIGN,DIGIT COUNT**");
		System.out.println("*****************************************\n");
		counter = 0;
		for(int i = 0; i < longIntArray.length; i++) {
			counter = i + 1;
			testCase(longIntArray[i]);			
		}
		nodeTraversalTime[0] = "Traversal";
		outputTime[0] = "output()";
		getSignTime[0] = "getSign()";
		digitCountTime[0] = "digitCount()";
		CSVWriter.writeLine(writer, nodeTraversalTime);
		CSVWriter.writeLine(writer, outputTime);
		CSVWriter.writeLine(writer, getSignTime);
		CSVWriter.writeLine(writer, digitCountTime);
	}
	
	private static void startTrial() {
		start = System.nanoTime();
	}
	
	private static void endTrial() {
		time = Double.toString(((System.nanoTime() - start)*.000000001));
	}
		
}
