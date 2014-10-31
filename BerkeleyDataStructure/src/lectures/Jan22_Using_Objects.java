package lectures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Jan22_Using_Objects {

	public static void main(String[] args) throws IOException {
		/*
		 * // test for simapleIODemo() Jan22_Using_Objects.simapleIODemo();
		 */
		/*
		 * // test for readLineFromUrl String url = "https://www.google.com";
		 * Jan22_Using_Objects.readLineFromUrl(url);
		 */
	}

	/**
	 * simple io
	 * */
	public static void simapleIODemo() throws IOException {
		BufferedReader keybd = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("output: " + keybd.readLine());
	}

	/**
	 * read the first line for url
	 *
	 * @throws IOException
	 * */
	public static void readLineFromUrl(String url) throws IOException {
		URL urlSteam = new URL(url);
		InputStream inputStream = urlSteam.openStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("URL output: " + bufferedReader.readLine());
	}

	/**
	 * stack and queue application:
	 *
	 * Sample application - stack: Verifying matched parentheses in a String
	 * like "{[(){[]}]()}". Scan through the String, character by character. o
	 * When you encounter a lefty--’{’, ’[’, or ’(’--push it onto the stack. o
	 * When you encounter a righty, pop its counterpart from atop the stack, and
	 * check that they match. If there’s a mismatch or null returned, or if the
	 * stack is not empty when you reach the end of the string, the parentheses
	 * are not properly matched.
	 *
	 * Sample application - queue: Printer queues. When you submit a job to be
	 * printed at a selected printer, your job goes into a queue. When the
	 * printer finishes printing a job, it dequeues the next job and prints it.
	 *
	 * */

}
