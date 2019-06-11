package br.imd.ufrn.model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkSearcher {
	
	private final static String DUCKDUCKGO_SEARCH_URL = "https://duckduckgo.com/html/?q=";
	
	public LinkSearcher() {
		
	}
	
	public static ArrayList<String> getLinkSearchResults(String query){
		Document doc = null;
		ArrayList<String> links = new ArrayList<String>();
		try {
			doc = Jsoup.connect(DUCKDUCKGO_SEARCH_URL + query).get();
			Elements results = doc.getElementById("links").getElementsByClass("results_links");
			
		    for(Element result: results){
		    	Element title = result.getElementsByClass("links_main").first().getElementsByTag("a").first();
		    	System.out.println("\nURL:" + title.attr("href"));
		    	System.out.println("Title:" + title.text());
		    	System.out.println("Snippet:" + result.getElementsByClass("result__snippet").first().text());
		    	links.add(title.attr("href"));
		    }
		    
		} catch (IOException e) {
		   e.printStackTrace(); 
		}
		
		return links;
	}
	
	public static String shortenText(String text) {
		return shortenText(text, 7);
	}
	public static String shortenText(String text, int maxWords) {
		String []words = text.split("\\s+");
		String finalText = "";
		int i=0;
		for(String s : words) {
			i++;
			finalText += s;
			finalText += " ";
			if(i == maxWords) {
				return finalText;
			}
		}
		return finalText;
		
	}
	
}
