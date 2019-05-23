package br.imd.ufrn.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Classe responsável pelo processamento de strings. Simplifica e codifica strings
 * 
 * @author Paulo Jr
 */

public class StrProcessor {
	/**
	 * Simplifica um texto retirando palavras pequenas, repetidas, transformando em lowercase etc.
	 * @param text texto a ser simplificado
	 * @return texto simplificado
	 */
	public String textSimplify(String text) {
		return textSimplify(text, 3);
	}
	
	/**
	 * Simplifica um texto retirando palavras pequenas, repetidas, transformando em lowercase etc.
	 * @param text texto a ser simplificado
	 * @param wordLen número mínimo de caracteres que uma string deve possuir
	 * @return texto simplificado
	 */
	public String textSimplify(String text, int wordLen) {
		String finalText = text;
		finalText = finalText.toLowerCase();
		finalText = removePunctuationAccent(finalText);
		
		//O(n), segundo https://softwareengineering.stackexchange.com/questions/331909/whats-the-complexity-of-javas-string-split-function
		String finalTextWordsArray[] = finalText.split(" ");
		
		//Nota: Para remover palavras pequenas de uma lista, é preferível que a estrutura trabalhada seja uma linked list, tendo 
		//em vista que a remoção durante uma iteração em um array é bem cara.

		//Arrays.aslist(): O(1), segundo https://stackoverflow.com/questions/1552783/performance-of-arrays-aslist
		//new LinkedList<String>(Collection): O(n), itera sobre a coleção provida no construtor ao mesmo tempo que adiciona na LinkedList criada. https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html#LinkedList(java.util.Collection)
		LinkedList<String> finalTextWords = new LinkedList<String>(Arrays.asList( finalTextWordsArray ));
		
		//O(n)
		finalTextWords = removeSmallWords(finalTextWords, wordLen);
		
		//O(n Log n). https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List)
		finalTextWords = wordsSorter(finalTextWords);
		

		return String.join(" ", finalTextWords);
	}
	
	/**
	 * Codifica uma string em sha-1
	 * @param text texto a ser codificado
	 * @return hash da string passada como parâmetro
	 * @throws NoSuchAlgorithmException
	 */
	public String textCrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		
		byte[] messageDigest = md.digest(text.getBytes());
		
        BigInteger no = new BigInteger(1, messageDigest); 
        
        String hashtext = no.toString(16); 
        
        while (hashtext.length() < 32) { 
            hashtext = "0" + hashtext; 
        } 
		
		return hashtext;
	}

	
	private String removePunctuationAccent(String text) {
		String finalText = text;
		
		// As duas próximas linhas foram soluções encontradas em 
		// https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette
		finalText = Normalizer.normalize(finalText, Normalizer.Form.NFD);
		finalText = finalText.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		finalText = finalText.replaceAll("[:,.!?\\-]", "");
		return finalText;
	}
	
	//Nesta função, pontuação também faz parte do tamanho de uma palavra
	private LinkedList<String> removeSmallWords(LinkedList<String> textWords, int wordLen) {
		
		for(Iterator<String> it = textWords.iterator(); it.hasNext();) {
			if( it.next().length() <= wordLen) {
				it.remove();
			}
		}

		return textWords;
	}
	
	private LinkedList<String> wordsSorter(LinkedList<String> textWords) {
		Collections.sort(textWords);
		return textWords;
	}
}
