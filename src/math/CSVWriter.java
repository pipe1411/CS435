package math;

import java.io.IOException;
import java.io.Writer;

public class CSVWriter {

	public static void writeLine(Writer write, String[] values) throws IOException {
		for(int i = 0; i < values.length; i++) {
			if(i == values.length - 1)
				write.append(values[i] + "\n");
			else
				write.append(values[i] + ",");
			
		}
	}
}
