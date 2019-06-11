package model;

import br.imd.ufrn.model.Leveinshtein;
import br.imd.ufrn.model.LinkSearcher;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LinkSearcherTeste {
	
	public static void main(String args[]) {
		LinkSearcher searcher = new LinkSearcher();
		String text = searcher.shortenText("OI, ISSO AQ É UM TESTE OK TABOM ESTOU ESCREVENDO MTS PALAVRAS PRA TESTAR");
		System.out.println(text);
		String query = "Quadrilha tentou sacar cheque de R$ 68 milhões.";
	}
	
}
