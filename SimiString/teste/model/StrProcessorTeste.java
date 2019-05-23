package model;
import java.security.NoSuchAlgorithmException;

import br.imd.ufrn.model.StrProcessor;

public class StrProcessorTeste {
	public static void main(String args[]) {
		StrProcessor processor = new StrProcessor();
		
		String text = "Isso aqui é um texto para conferir a funcionalidade da classe strprocessor. 10, 15, 28, 56.";
		String simplerText = processor.textSimplify(text, 0);
		System.out.println(simplerText);
	}
}
