package br.imd.ufrn.model;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebScrapper {
	
	private URL url;
	private String _page;
	
	public WebScrapper(URL url) {
		this.url = url;
		URLConnection connection;
		Scanner scanner;
		try {
			connection = url.openConnection();
			scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			_page = scanner.next();
			scanner.close();
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
	}
	
	public void setUrl(URL url) {
		this.url = url;
	}
	
	public URL getUrl() {
		return url;
	}
	/**
	 * @return Retorna o conteúdo da próxima tag <p></p> do site
	 * @throws Exception
	 */
	public String getNextParagraph() throws Exception {
		if(url == null)
		{
			throw new Exception("Nenhuma url foi especificada");
		}
		
		
		return null;
	}
}
