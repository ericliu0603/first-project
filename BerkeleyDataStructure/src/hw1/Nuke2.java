package hw1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nuke2 {

	public static void main(String[] args) throws Exception {
		System.out.println(Nuke2.getNuke2StringFromKeyboard());
	}

	public static String getNuke2StringFromKeyboard() throws Exception {
		System.out.println("Input: ");
		BufferedReader keybd = new BufferedReader(new InputStreamReader(
				System.in));
		String originalStr = keybd.readLine();
		if (originalStr.length() < 2) {
			throw new Exception("Need input with length larger than 2.");
		}
		String result = originalStr.substring(0, 1) + originalStr.substring(2);
		return result;
	}

}
