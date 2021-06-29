package testData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * I didît have enough time to finish it
 */
public class Reader {

	String path = "../ShoppingTest.csv";
	
	public void fun() throws IOException{
	BufferedReader csvReader = new BufferedReader(new FileReader(path));

		while (csvReader.readLine() != null) {
	    String[] data = csvReader.readLine().split(",");
	    // save the data
	}
		csvReader.close();
	}
	
}
