package math;

import java.io.FileWriter;
import java.io.IOException;
//For Testing purposes only
//import java.math.BigInteger;
 

public class StepTwo {
	private static String A = "2222";
	private static String B = "99999999";
	private static String C = "-246813575732";
	private static String D = "180270361023456789";
	private static String E = "1423550000000010056810000054593452907711568359";
	private static String F = "-350003274594847454317890";
	private static String G = "29302390234702973402973420937420973420937420937234872349872934872893472893749287423847";
	private static String H = "-98534342983742987342987339234098230498203894209928374662342342342356723423423";
	private static String I = "8436413168438618351351684694835434894364351846843435168484351684684315384684313846813153843135138413513843813513813138438435153454154515151513141592654543515316848613242587561516511233246174561276521672162416274123076527612";
	private static LongInt[] longIntArray = new LongInt[9];
	//private static BigInteger[] bigIntegerArray = new BigInteger[9];
	private static final String[] LETTER_MAP = {"A","B","C","D","E","F","G","H","I"};
	private static long start;
	private static String time;
	private static FileWriter writer;
	
	
	public static void begin(FileWriter write) throws IOException {
		writer = write;
		String[] numbers = {A,B,C,D,E,F,G,H,I};
		initializeLongIntArray(numbers);
		addition();
		subtraction();
		multiplication();
		power();
		computeTheFollowing();
	}
	/**
	 * Initializes the longIntArray that will contain all of A-I LongInt's
	 * @param numbers the set of all numbers represented as Strings
	 * @return Nothing is returned
	 */
	private static void initializeLongIntArray(String[] numbers){
		for(int i = 0; i < longIntArray.length; i++) {
			longIntArray[i] = new LongInt(numbers[i]);
			//bigIntegerArray[i] = new BigInteger(numbers[i]);
		}
	}
	
	private static void addition() throws IOException {
		String[] additionTime = new String[10];
		additionTime[0] = "add()";
		
		System.out.println("\n********************");
		System.out.println("******ADDITION******");
		System.out.println("********************\n");
		
		for(int i = 0; i < longIntArray.length; i++) {
			LongInt a = longIntArray[i];
			//BigInteger c = bigIntegerArray[i];
			
			for(int j = 0; j < longIntArray.length; j++) {
				startTrial();
				LongInt b = a.add(longIntArray[j]);
				endTrial();
				if(i == j)
					additionTime[i + 1] = time;
				//BigInteger e = c.add(bigIntegerArray[j]);
				System.out.println(LETTER_MAP[i] + " + " + LETTER_MAP[j] + ": ");
				b.output();
				System.out.println();
				//System.out.println(e);
			}
		}
		CSVWriter.writeLine(writer, additionTime);
	}
	
	private static void subtraction() throws IOException {
		String[] subtractTime = new String[10];
		subtractTime[0] = "subtract()";
		
		System.out.println("\n*******************");
		System.out.println("****SUBTRACTION****");
		System.out.println("*******************\n");
		
		for(int i = 0; i < longIntArray.length; i++) {
			LongInt a = longIntArray[i];
			//BigInteger c = bigIntegerArray[i];
			
			for(int j = 0; j < longIntArray.length; j++) {
				startTrial();
				LongInt b = a.subtract(longIntArray[j]);
				endTrial();
				if(i == j)
					subtractTime[i+1] = time;
				//BigInteger e = c.subtract(bigIntegerArray[j]);
				System.out.println(LETTER_MAP[i] + " - " + LETTER_MAP[j] + ": ");
				b.output();
				System.out.println();
				//System.out.println(e);
			}
		}
		
		CSVWriter.writeLine(writer, subtractTime);
	}
	
	private static void multiplication() throws IOException {
		String[] multiplicationTime = new String[10];
		multiplicationTime[0] = "multiply()";
		
		System.out.println("\n**********************");
		System.out.println("****MULTIPLICATION****");
		System.out.println("**********************\n");
		
		for(int i = 0; i < longIntArray.length; i++) {
			LongInt a = longIntArray[i];
			//BigInteger c = bigIntegerArray[i];
			
			for(int j = 0; j < longIntArray.length; j++) {
				startTrial();
				LongInt b = a.multiply(longIntArray[j]);
				endTrial();
				if(i == j)
					multiplicationTime[i+1] = time;
				//BigInteger e = c.multiply(bigIntegerArray[j]);
				System.out.println(LETTER_MAP[i] + " * " + LETTER_MAP[j] + ": ");
				b.output();
				System.out.println();
				//System.out.println(e);
			}
		}
		CSVWriter.writeLine(writer, multiplicationTime);
	}
	
	private static void power() throws IOException {
		String[] power5 = new String[10];
		power5[0] = "power(5)";
		String[] power10 = new String[10];
		power10[0] = "power(10)";
		String[] power20 = new String[10];
		power20[0] = "power(20)";
		
		System.out.println("\n*********************");
		System.out.println("********POWER********");
		System.out.println("*********************\n");
		
		int[] powers = {5,10,20};
		for(int i = 0; i < longIntArray.length; i++) {
			LongInt a = longIntArray[i];
			//BigInteger c = bigIntegerArray[i];
			
			for(int j = 0; j < powers.length; j++) {
				//TODO revert back
				startTrial();
				LongInt b = a.power(powers[j]);
				endTrial();
				
				switch(powers[j]) {
				case 5:
					power5[i+1] = time;
				break;
				case 10:
					power10[i+1] = time;
				break;
				case 20:
					power20[i+1] = time;
				default :
					break;
					
				}
				//BigInteger e = c.pow(powers[j]);
				System.out.println(LETTER_MAP[i] + "^" + powers[j] + ": ");
				b.output();
				System.out.println();
				//System.out.println(e);
			}
		}
		CSVWriter.writeLine(writer, power5);
		CSVWriter.writeLine(writer, power10);
		CSVWriter.writeLine(writer, power20);
		
	}
	
	private static void computeTheFollowing() {

		System.out.println("\n*********************");
		System.out.println("********OTHER********");
		System.out.println("*********************\n");
		
		
		LongInt J = map("B").add(map("C"));
		System.out.println("J: ");
		J.output();
		System.out.println();
		//BigInteger j = mapa("B").add(mapa("C"));
		//System.out.println(j);
		
		LongInt K = map("C").add(map("D"));
		System.out.println("K: ");
		K.output();
		System.out.println();
		//BigInteger k = mapa("C").add(mapa("D"));
		//System.out.println(k);
		
		LongInt L = map("I").add(map("I"));
		System.out.println("L: ");
		L.output();
		System.out.println();
		//BigInteger l = mapa("I").add(mapa("I"));
		//System.out.println(l);
		
		LongInt M = map("A").add(map("I"));
		System.out.println("M: ");
		M.output();
		System.out.println();
		//BigInteger m = mapa("A").add(mapa("I"));
		//System.out.println(m);
		
		LongInt N = map("B").add(K);
		System.out.println("N: ");
		N.output();
		System.out.println();
		//BigInteger n = mapa("B").add(k);
		//System.out.println(n);
		
		LongInt O = map("A").subtract(map("D"));
		System.out.println("O: ");
		O.output();
		System.out.println();
		//BigInteger o = mapa("A").subtract(mapa("D"));
		//System.out.println(o);
		
		LongInt P = map("C").subtract(map("D"));
		System.out.println("P: ");
		P.output();
		System.out.println();
		//BigInteger p = mapa("C").subtract(mapa("D"));
		//System.out.println(p);
		
		LongInt Q = map("D").subtract(map("C"));
		System.out.println("Q: ");
		Q.output();
		System.out.println();
		//BigInteger q = mapa("D").subtract(mapa("C"));
		//System.out.println(q);
		
		LongInt R = L.subtract(L);
		System.out.println("R: ");
		R.output();
		System.out.println();
		//BigInteger r = l.subtract(l);
		//System.out.println(r);
		
		LongInt S = P.subtract(O);
		System.out.println("S: ");
		S.output();
		System.out.println();
		//BigInteger s = p.subtract(o);
		//System.out.println(s);
		
		LongInt T = N.subtract(Q);
		System.out.println("T: ");
		T.output();
		System.out.println();
		//BigInteger t = n.subtract(q);
		//System.out.println(t);
		
		LongInt U = map("A").multiply(map("D"));
		System.out.println("U: ");
		U.output();
		System.out.println();
		//BigInteger u = mapa("A").multiply(mapa("D"));
		//System.out.println(u);
		
		LongInt V = map("B").multiply(map("C"));
		System.out.println("V: ");
		V.output();
		System.out.println();
		//BigInteger v = mapa("B").multiply(mapa("C"));
		//System.out.println(v);
		
		LongInt W = map("D").multiply(map("D"));
		System.out.println("W: ");
		W.output();
		System.out.println();
		//BigInteger w = mapa("D").multiply(mapa("D"));
		//System.out.println(w);
		
		LongInt X = O.multiply(map("I"));
		System.out.println("X: ");
		X.output();
		System.out.println();
		//BigInteger x = o.multiply(mapa("I"));
		//System.out.println(x);
		
		LongInt Y = J.multiply(P);
		System.out.println("Y: ");
		Y.output();
		System.out.println();
		//BigInteger y = j.multiply(p);
		//System.out.println(y);
		
		LongInt Z = M.multiply(N);
		System.out.println("Z: ");
		Z.output();
		System.out.println();
		//BigInteger z = m.multiply(n);
		//System.out.println(z);
	}
	
	private static LongInt map(String a) {
		for(int i = 0; i < LETTER_MAP.length;i++) {
			if(LETTER_MAP[i].equals(a))
				return longIntArray[i];
		}
		
		return null;
	}
	
	/*private static BigInteger mapa(String a) {
		for(int i = 0; i < LETTER_MAP.length;i++) {
			if(LETTER_MAP[i].equals(a))
				return bigIntegerArray[i];
		}
		
		return null;
	}*/
	
	private static void startTrial() {
		start = System.nanoTime();
	}
	
	private static void endTrial() {
		time = Double.toString(((System.nanoTime() - start)*.000000001));
	}

}
