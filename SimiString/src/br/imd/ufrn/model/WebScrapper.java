package br.imd.ufrn.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Realiza operações de webscrapping que importam ao projeto
 * 
 * @author pj
 */

public class WebScrapper {
	
	private String url;
	private Document _doc;
	private Elements _paragraphs;
	
	/**
	 * Chama setUrl com url recebida
	 * 
	 * @param url Endereço do site
	 * @throws Exception Caso haja algum erro no parsing da página, ou a url, uma exceção será lançada
	 */
	public WebScrapper(String url) throws Exception {
		setUrl(url);
	}
	
	/**
	 * Atribui valor à variável url. Cria conecção com a url, fetcha e parsa a url extraindo as tags <p> da página.
	 * 
	 * @param url Endereço do site
	 * @throws Exception Caso haja algum erro no parsing da página, ou a url, uma exceção será lançada
	 */
	public void setUrl(String url) throws Exception{

		this.url = url;
		this._doc = Jsoup.connect(url).get();
		_paragraphs = _doc.select("p");
		
	}
	/**
	 * Retorna valor da url
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @return Retorna todas as tags <p> da página
	 */
	public ArrayList<String> getParagraphs() {
		
		ArrayList<String> paragraphs = new ArrayList<String>();
		
		for( Element p : _paragraphs ) {
			paragraphs.add( p.text() );
		}
		
		return paragraphs;
		
	}
}
