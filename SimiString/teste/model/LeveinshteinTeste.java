package model;

import java.security.NoSuchAlgorithmException;

import br.imd.ufrn.model.Leveinshtein;
import br.imd.ufrn.model.StrProcessor;

	public class LeveinshteinTeste {
		public static void main(String args[]) {
			
//		String text1 = "tage, you have to use this to points to scale. For exa";
//		String text2 = "iki too and wondered if it was just this. The reason is that I read somethi";

		String text1 = "abacaxi";
		String text2 = "carro";
			
		System.out.println(text1);
		System.out.println(text2);
		
		Leveinshtein simil = new Leveinshtein();
		int semelhanca = simil.checkDistance(text1, text2);
		System.out.println("Numero de modificações é: " + semelhanca);
		System.out.println("indice de similaridade é: " + simil.indiceSimil());
		}
	}



