package Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFun {
	public static String readFromFile(String fileName) throws IOException{
		String response = null;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line != null) {
            response+=line+"\n";
            line = br.readLine();
      }
		br.close();
		return response;
	}
}
