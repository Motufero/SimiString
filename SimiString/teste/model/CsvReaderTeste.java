package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import br.imd.ufrn.model.CsvReader;

public class CsvReaderTeste {
	public static void main(String args[]) {
		String caminho = "../boatos.csv";
		CsvReader reader;
		try {
			
			reader = new CsvReader(caminho);
			ArrayList<String> linha;
			do{
				linha = reader.getNextRecord();
				for(String s : linha) {
					System.out.print(s + " | ");
				}
				System.out.println();
				Thread.sleep(5);
			}while(linha.size() > 0);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
