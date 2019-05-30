package br.imd.ufrn.model;

import java.util.Date;
/**
 * 
 * Classe para armazenar dados de uma notícia
 * @author pj
 * 
 */
public class News {
	private String texto, url;
	private Date data;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
