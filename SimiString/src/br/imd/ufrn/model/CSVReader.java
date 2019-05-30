package br.imd.ufrn.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe responsável pela leitura do arquivo csv, no momento ela so imprime os boatos, 
 * mas será util para separar os boatos dos links e timestamps usando csvDivisor
 * 
 */


public class CSVReader {

	/**
	 * Função para fazer a leitura, para isso foi criado uma pasta com 
	 * os arquivos csv disponibilizados no sigaa
	 * 
	 */
	
	public void readCSV() {
		BufferedReader br = null;
		String linha ="";
		int contador =0;
		String csvDivisor = ",https:"; //para isolar apenas o boato.
		
		
		try {
			br = new BufferedReader(new FileReader("CSVFile/boatos.csv"));
			while((linha = br.readLine()) != null) {
				
				if(contador==0) {
					System.out.println("Cabeçalho-> " + linha);
					contador++;
				}else {
				String boatoCompleto = "";
				String[]boato = linha.split(csvDivisor);
				
				boatoCompleto = boato[0];
				contador++;
			
				System.out.println("Boato: " + contador +"  " + boatoCompleto.toLowerCase());
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if  (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}			
			}
		}
	}