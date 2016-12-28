package math;

import java.io.FileWriter;
import java.io.IOException;

/*
 * REFERENCES TO THE BIGINTEGER LIBRARY ARE 
 * FOR TESTING PURPOSES ONLY. ALL LINES HAVE
 * BEEN COMMENTED OUT
 * 
 * *******************************************
 * ******import java.math.BigInteger;*********
 * *******************************************
 */



/**
 * The standard library of many languages includes a “Big Integer” or ”Long Integer” data type which
 * can store arbitrarily large integers. This program implements such a Long Integer Data Type (“LongInt”),
 * where there is no predefined limit on the maximum value that can be stored. Such a LongInt can have an arbitrary
 * number of digits (i.e., tens of thousands of digits, or millions of digits). The following abstract operations are
 * defined for the LongInt: ADD, SUBSTRACT, MULTIPLY, DIVIDE, POWER, and various comparison operations (e.g.,
 * LESS THAN). The LongInt data type also has two properties associated with it: sign and number of digits.
 * When representing a LongInt, each position of the LongIntList ADT will store at most 8 digits of the overall number.
 * Every position will store a positive value, as the sign will be represented as a property of the LongInt.
 * This program implements the LongInt using two data structures: singly linked list and array
 * 
 * @author Andres F. Arango Valencia
 * @version 2.0
 * @since 11-28-2016
 */
public class Main {
	public static void main(String[] args) throws IOException {
		
		//FileWriter writer = new FileWriter("/Users/pipe/Google Drive/school/CS 435/runningTime.csv",true);
		FileWriter writer = new FileWriter("runningTime.csv",true);
		long start = System.nanoTime();
		
		StepOne.begin(writer);
		StepTwo.begin(writer);
		
		long time = System.nanoTime() - start;

		String[] totalTime = {"Time Elapsed ", Double.toString(time*.000000001)};
		CSVWriter.writeLine(writer, totalTime);
		writer.flush();
		writer.close();
		System.out.println("\n***************************************");
		System.out.println("****PROGRAM TERMINATED SUCCESSFULLY****");
		System.out.println("***************************************");
	
		
	}	
	
	
}
