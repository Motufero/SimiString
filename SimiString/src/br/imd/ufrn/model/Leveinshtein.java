package br.imd.ufrn.model;


/**
 * Classe responsável por verificar similaridade entre duas Strings
 * Codigo obtido em: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 *
 * @author Saulo Gabriel
 */


public class Leveinshtein extends SimiAlg{
	private int levelVar = 0;
	private String lText1, lText2;
	
/**
 * 	
 * @param str1 Texto 1
 * @param str2 Texto 2
 * @return numero de inserções, deleções ou substituições necessárias para transformar 
 * texto 1 em texto 2
 */
	

	public int checkDistance (String text1, String text2) {
		lText1 = text1;
		lText2 = text2;
		
		char[] str1 = text1.toCharArray();
		char[] str2 = text2.toCharArray();
		
		int temp[][] = new int[str1.length+1][str2.length+1];
	        
	        for(int i=0; i < temp[0].length; i++){
	            temp[0][i] = i;
	        }
	        
	        for(int i=0; i < temp.length; i++){
	            temp[i][0] = i;
	        }
	        
	        for(int i=1;i <=str1.length; i++){
	            for(int j=1; j <= str2.length; j++){
	                if(str1[i-1] == str2[j-1]){
	                    temp[i][j] = temp[i-1][j-1];
	                }else{
	                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
	                }
	            }
	        }
	        levelVar = temp[str1.length][str2.length];
	        return temp[str1.length][str2.length];
	        
	    }

	/**
	 * Funçao para calcular valor minimo (serve apenas para auxiliar Leveinshtein)
	 * 
	 */
	
	private int min(int val1, int val2, int val3) {
		if (val1 <= val2 && val1 <= val3) {
			return val1;
		}
		if (val2 <= val1 && val2 <= val3) {
			return val2;
		}else {
			return val3;
		}
		
	}
	 
	/**
	 * Função que vai dar o percentual de quanto uma String é semelhante a outra
	 * @param leveinVar valor resultado da função Leveinshtein
	 * @param tamanho1 tamanho da primeira String
	 * @param tamaho2 tamanho da segunda String
	 * @return
	 */
	
	
	public double indiceSimil() {
		int tamanho1 = lText1.length();
		int tamanho2 = lText2.length();
		if(tamanho1>=tamanho2) {
			return ((double)tamanho1/(tamanho1+levelVar));
		} else {
			return ((double)tamanho2/(tamanho2+levelVar));
		}
		
	}

	@Override
	public double getSimilarity() {
		// TODO Auto-generated method stub
		similarity = indiceSimil();
		return super.getSimilarity();
	}


	
	
}
