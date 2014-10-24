package hw1;

/* OpenCommercial.java */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Stack;

/**
 * A class that provides a main function to read five lines of a commercial Web
 * page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

	/**
	 * Prompts the user for the name X of a company (a single string), opens the
	 * Web site corresponding to www.X.com, and prints the first five lines of
	 * the Web page in reverse order.
	 *
	 * @param arg
	 *            is not used.
	 * @exception Exception
	 *                thrown if there are any problems parsing the user's input
	 *                or opening the connection.
	 */
	public static void main(String[] arg) throws Exception {

		BufferedReader keyboard;
		String inputLine;

		keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.print("Please enter the name of a company (without spaces): ");
		System.out.flush(); /* Make sure the line is printed immediately. */
		inputLine = keyboard.readLine();

		String url = "http://www." + inputLine + ".com/";
		URL urlStream = new URL(url);
		InputStream inputStream = urlStream.openStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader webReader = new BufferedReader(inputStreamReader);
		Stack<String> buffer = new Stack<String>();
		for (int i = 0; i < 5; ++i) {
			buffer.push(webReader.readLine());
		}
		while (!buffer.empty()) {
			System.out.println(buffer.pop());
		}
	}
}
