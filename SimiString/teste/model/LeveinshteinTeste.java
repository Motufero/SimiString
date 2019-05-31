package model;

import java.security.NoSuchAlgorithmException;

import br.imd.ufrn.model.Leveinshtein;
import br.imd.ufrn.model.StrProcessor;

	public class LeveinshteinTeste {
		public static void main(String args[]) {
		StrProcessor processor = new StrProcessor();
			
		String text = "Isso aqui é um texto para conferir a funcionalidade da classe strprocessor. 10, 15, 28, 56.";
		String simplerText = processor.textSimplify(text);
		System.out.println(simplerText);
	
		String text2 = "Isso aqui é um texto para conferir a funcionalidade da função de Leveinhstein";
		String simplerText2 = processor.textSimplify(text2);
		System.out.println(simplerText2);
		
		
		Leveinshtein simil = new Leveinshtein();
		int semelhanca;
		semelhanca=simil.checkDistance(simplerText.toCharArray(), simplerText2.toCharArray());
		System.out.println("Numero de modificações é: " + semelhanca);
		System.out.println("indice de similaridade: " + simil.indiceSimil(semelhanca, simplerText.length(), simplerText2.length()));
		}
	}



