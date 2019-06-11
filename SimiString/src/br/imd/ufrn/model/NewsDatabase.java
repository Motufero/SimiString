package br.imd.ufrn.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 * Armazenamento de notícias. Abstrai como e em qual estrutura de dados o armazenamento, remoção e busca é feito.
 * 
 * @author Paulo Jr
 */
public class NewsDatabase {
	private Hashtable<String, News> database;
	
	public NewsDatabase() {
		database = new Hashtable<String, News>();
	}
	
	/**
	 * Adicionar notícias no banco de dados
	 * @param aNews Notícia a adicionar
	 */
	public void addNews( News aNews ) {
		StrProcessor strp = new StrProcessor();
		String hash;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNews.getTexto(), 3) );
			database.put(hash, aNews);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Remove notícia cuja chave é o hash gerado pelo texto da notícia que se quer remover
	 * @param aNews Notícia que se quer remover
	 */
	public void removeNewsHash( News aNews ) {
		StrProcessor strp = new StrProcessor();
		String hash;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNews.getTexto(), 3) );
			database.remove(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retorna todos os valores do dicionário
	 * @return Coleção contendo os valores
	 */
	public ArrayList<News> getNews(){
		ArrayList<News> news = new ArrayList<News>();
		for(News databaseNews : database.values()) {
			news.add(databaseNews);
		}
		return news;
	}
	
	/**
	 * Pesquisa pela news com o método hash. Somente o texto da notícia é importante para o resultado da busca.
	 * @param aNews será feita a busca dessa notícia 
	 * @return News encontrada
	 */
	public News getNewsHash( News aNews ) {
		StrProcessor strp = new StrProcessor();
		String hash = null;
		News foundNews = null;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNews.getTexto(), 3) );
			foundNews = database.get(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//TODO: Melhor tratar
		}
		return foundNews;
	}
	/**
	 * Pesquisa por news semelhantes com o método Leveinshtein. Somente o texto da notícia é importante para o resultado da busca.
	 * @param aNews será feita a busca dessa notícia 
	 * @return News encontrada
	 */
	public ArrayList<News> getNewsLeveinshtein( News aNews ) {
		return getNewsLeveinshtein( aNews, 0.8 );
	}
	
	public ArrayList<News> getNewsLeveinshtein( News aNews, double minPer ) {
		Leveinshtein lev = new Leveinshtein();
		ArrayList<News> similarNews = new ArrayList<News>();
		StrProcessor strp = new StrProcessor();
		
		for(News databaseNews : database.values()) {
			
			int distance = lev.checkDistance(strp.textSimplify(aNews.getTexto(), 3), strp.textSimplify(databaseNews.getTexto(), 3));
			double similarity = lev.indiceSimil();
			
			if( similarity >= minPer ) {
				similarNews.add(databaseNews);
			}
		}
		
		return similarNews;	
	}
	
	public double firstSimilarLeveinshtein(News aNews, double minPer) {
		Leveinshtein lev = new Leveinshtein();
		StrProcessor strp = new StrProcessor();
		
		double maxSimilarity = 0;
		for(News databaseNews : database.values()) {
			
			int distance = lev.checkDistance(strp.textSimplify(aNews.getTexto(), 3), strp.textSimplify(databaseNews.getTexto(), 3));
			double similarity = lev.indiceSimil();
			
			if(maxSimilarity < similarity) {
				maxSimilarity = similarity;
			}
			
			if( similarity >= minPer ) {
				return similarity;
			}
		}
		
		return maxSimilarity;	
	}

}
