package model;

import java.util.ArrayList;

import br.imd.ufrn.model.Leveinshtein;
import br.imd.ufrn.model.News;
import br.imd.ufrn.model.NewsDatabase;

public class NewsDatabaseTeste {
	public static void main(String args[]) {
		
		NewsDatabase database = new NewsDatabase();
				
		database.addNews( new News("noticia 1 asfdo pamuq vasdf ", null, null) );
		database.addNews( new News("noticia 2 asfdo nfuslx aftw ", null, null) );
		database.addNews( new News("noticia 3 asfdo zpaleqbv qreyhs ", null, null) );
		database.addNews( new News("noticia 4 asfdo emcha gxa ", null, null) );
		database.addNews( new News("noticia 5 asfdo gsar hgjms ", null, null) );
		
		String sample = "Noticia x. asndb adsn oqwntp";
		System.out.println("Notícia a ser buscada no banco de dados: ");
		System.out.println(sample);
		
		System.out.println("\nNotícias do banco de dados e sua similaridade com a notícia a ser buscada pelo método Leveinshtein:");
		Leveinshtein lev = new Leveinshtein();
		for(News n : database.getNews()) {
			int distance = lev.checkDistance( sample, n.getTexto());
			double similarity = lev.indiceSimil();
			
			System.out.printf("%.05f", similarity);
			System.out.println( " <- " + n.getTexto());
		}
		
		System.out.println("\nBusca da notícia pelo método Leveinshtein com índice mínimo de similaridade de 65%:");
		
		ArrayList<News> newsParecidas = database.getNewsLeveinshtein(new News(sample, null, null), 0.65);
		for(News n : newsParecidas) {
			System.out.println(n.getTexto());
		}
		
	}
}
