package br.imd.ufrn.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Leitura e parsing de csv
 * 
 * @author Saulo Gabriel, Paulo Jr
 */


public class CsvReader {
	
	String filePath;
	BufferedReader br;
	
	/**
	 * Chama setFilePath com filePath de parâmetro
	 * 
	 * @param filePath Caminho para o arquivo. Não precisa ser caminho absoluto.
	 * @throws FileNotFoundException
	 */
	public CsvReader(String filePath) throws FileNotFoundException {
		setFilePath(filePath);
		
	}
	
	/**
	 * Atribui valor a filePath e abre o buffer para ler o csv
	 * @param filePath Caminho para o arquivo. Não precisa ser caminho absoluto.
	 * @throws FileNotFoundException
	 */
	public void setFilePath(String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		this.br = new BufferedReader(new FileReader(filePath));
	}
	
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * Retorna a próxima linha do csv
	 * @return Lista contendo os campos da linha
	 * @throws IOException
	 */
	public ArrayList<String> getNextRecord() throws IOException{
		ArrayList<String> values = new ArrayList<String>();
		String line = br.readLine();
		if(line!=null)
		{
			try (Scanner rowScanner = new Scanner( line )) {
			    rowScanner.useDelimiter(",");
			    while (rowScanner.hasNext()) {
			        values.add(rowScanner.next());
			    }
			}
		}
	    return values;
	}

	
	
}