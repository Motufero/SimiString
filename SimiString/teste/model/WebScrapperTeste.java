package model;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import br.imd.ufrn.model.WebScrapper;

public class WebScrapperTeste {
	public static void main(String args[]) {
		
		//Deve conter http:// ou https:// pra funcionar
		String website = "https://www.gazetadopovo.com.br/republica/governo-regulamentar-direito-greve-servidor/";
		
		try {
			WebScrapper scrapper = new WebScrapper(website);
			
			for(String p : scrapper.getParagraphs())
			{
				if(p.length() > 200)
				{
					System.out.println(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
