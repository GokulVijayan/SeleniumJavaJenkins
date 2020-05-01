package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {

	/**
	 * Parse the input file specified using relativePath parameter and returns
	 * buffered reader object
	 * 
	 * @param relativePath
	 * @return bufferedReader
	 * @throws FileNotFoundException
	 */

	public static BufferedReader ParseFile(String relativePath) throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(Constant.currentDirectory + relativePath));
		return bufferedReader;
	}
}
