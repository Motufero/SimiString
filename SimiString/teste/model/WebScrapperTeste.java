package model;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebScrapperTeste {
	public static void main(String args[]) {
		String content = null;
		URLConnection connection = null;
		try {
		  connection =  new URL("http://www.google.com").openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  content = scanner.next();
		  scanner.close();
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		System.out.println(content);
	}
}
