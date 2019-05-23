package model;
import java.security.NoSuchAlgorithmException;

import br.imd.ufrn.model.StrProcessor;

public class StrProcessorTeste {
	public static void main(String args[]) {
		StrProcessor processor = new StrProcessor();
		
		String text = "Isso aqui é um texto para conferir a funcionalidade da classe strprocessor. Preciso falar alguns números: 10, 15, 28, 56.";
		String simplerText = processor.textSimplify(text);
		
		try {
			System.out.println(processor.textCrypt(simplerText));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
