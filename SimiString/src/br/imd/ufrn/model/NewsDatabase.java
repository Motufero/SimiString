package br.imd.ufrn.model;

import java.security.NoSuchAlgorithmException;
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
	
	public void addNews( News aNew ) {
		StrProcessor strp = new StrProcessor();
		String hash;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNew.getTexto(), 3) );
			database.put(hash, aNew);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public void removeNews( News aNew ) {
		StrProcessor strp = new StrProcessor();
		String hash;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNew.getTexto(), 3) );
			database.remove(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Pesquisa pela news com o método hash. Somente o texto da notícia é importante para o resultado da busca.
	 * @param aNews será feita a busca dessa notícia 
	 * @return News encontrada
	 */
	public News getNewsHash( News aNew ) {
		StrProcessor strp = new StrProcessor();
		String hash = null;
		News foundNews = null;
		try {
			hash = strp.textCrypt( strp.textSimplify(aNew.getTexto(), 3) );
			foundNews = database.get(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//TODO: Melhor tratar
		}
		return foundNews;
	}
	/**
	 * Pesquisa por news semelhantes com o método Leveinshtein. Somente o texto da notícia é importante para o resultado da busca.
	 * @param aNew será feita a busca dessa notícia 
	 * @return News encontrada
	 */
	public void getNewsLeveinshtein( News aNew ) {
		
	}

}
