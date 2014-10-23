package lectures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Jan22_Using_Objects {

	public static void main(String[] args) throws IOException {
		/*
		// test for simapleIODemo()
		Jan22_Using_Objects.simapleIODemo();
		*/
		/*
		// test for readLineFromUrl
		String url = "https://www.google.com";
		Jan22_Using_Objects.readLineFromUrl(url);
		*/
	}
	
	/**
	 * simple io
	 * */
	public static void simapleIODemo() throws IOException{
		BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("output: " + keybd.readLine());
	}
	
	/**
	 * read the first line for url
	 * @throws IOException 
	 * */
	public static void readLineFromUrl(String url) throws IOException{
		URL urlSteam = new URL(url);
		InputStream inputStream =urlSteam.openStream(); 
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("URL output: " + bufferedReader.readLine());
	}

}
