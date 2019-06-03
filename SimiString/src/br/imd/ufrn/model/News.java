package br.imd.ufrn.model;

import java.util.Date;
/**
 * 
 * Classe para armazenar dados de uma notícia
 * @author Paulo Jr
 * 
 */
public class News {
	private String texto, url;
	private Date date;
	
	public News() {
		
	}
	public News(String texto, String url, Date date) {
		this.texto = texto;
		this.url = url;
		this.date = date;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date data) {
		this.date = data;
	}
}
